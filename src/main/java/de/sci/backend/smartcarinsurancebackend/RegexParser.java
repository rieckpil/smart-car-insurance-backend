package de.sci.backend.smartcarinsurancebackend;

import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Vertex;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegexParser {

    static class Address {
        String street = "Bahnhofsplatz";
        String plz = "96450";
        String location = "Coburg";

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", plz='" + plz + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getPlz() {
            return plz;
        }

        public void setPlz(String plz) {
            this.plz = plz;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }

    static class CarData {
        String HSN = "0603";
        String TSN = "BPG";
        String surname = "Paul";
        String name = "Brendel";
        Address address = new Address();

        @Override
        public String toString() {
            return "CarData{" +
                    "HSN='" + HSN + '\'' +
                    ", TSN='" + TSN + '\'' +
                    ", surname='" + surname + '\'' +
                    ", name='" + name + '\'' +
                    ", address=" + address +
                    '}';
        }

        public String getHSN() {
            return HSN;
        }

        public void setHSN(String HSN) {
            this.HSN = HSN;
        }

        public String getTSN() {
            return TSN;
        }

        public void setTSN(String TSN) {
            this.TSN = TSN;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    static private EntityAnnotation findFirst(List<EntityAnnotation> list, String find) {

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getDescription().contains(find)) {
                return list.get(i);
            }
        }

        return null;
    }


    static private String findBelow(List<EntityAnnotation> list, EntityAnnotation above) {
        Polygon polygon = getPolygon(above, true);
        AtomicReference<String> s = new AtomicReference<>("");
        list.subList(1, list.size() - 1).stream().filter(x -> polygon.getBounds().intersects(getPolygon(x, false).getBounds())).forEach(x -> s.updateAndGet(v -> v + x.getDescription() + " "));
        return s.get();
    }

    static private Polygon getPolygon(EntityAnnotation above, boolean offset) {
        int maxX = above.getBoundingPoly().getVerticesList().stream().map(Vertex::getX).max(Comparator.comparing(Float::valueOf)).get();
        int minX = above.getBoundingPoly().getVerticesList().stream().map(Vertex::getX).min(Comparator.comparing(Float::valueOf)).get();
        int maxY = above.getBoundingPoly().getVerticesList().stream().map(Vertex::getY).max(Comparator.comparing(Float::valueOf)).get();
        int minY = above.getBoundingPoly().getVerticesList().stream().map(Vertex::getY).min(Comparator.comparing(Float::valueOf)).get();
        float width = maxX - minX;
        float height = maxY - minY;
        Polygon polygon = new Polygon();
        if (offset) {
            minY += height;
            maxY += height * 6;
            maxX += width * 4;
        }
        polygon.addPoint(minX, minY);
        polygon.addPoint(maxX, maxY);
        return polygon;
    }


    /**
     * @param list
     * @return CarData Object with parsed Data
     */
    public static CarData parse(List<EntityAnnotation> list) {

        String text = list.get(0).getDescription();

        System.out.println(text);

        String[] lines = text.split("\n");
        CarData data = new CarData();
        for (int i = 0; i < lines.length; i++) {
            String e = lines[i];
            if (i == lines.length - 2) break;
            ExtractedResult er = FuzzySearch.extractOne("Vorname", Arrays.asList(e.split(" ")));
            if (er.getScore() > 70 && er.getString().length() > 5) {
                i++;
                data.surname = lines[i].replace(" ", "");
                continue;
            }
            er = FuzzySearch.extractOne("Anschrift", Arrays.asList(e.split(" ")));
            if (er.getScore() > 70 && er.getString().length() > 5) {
                i++;

                String add = findBelow(list, findFirst(list, er.getString()));
                Pattern p = Pattern.compile("(.+)\\s+(\\d{5})\\s+(.+)");
                Matcher matcher = p.matcher(add);
                while (matcher.find()) {
                    data.address.street = matcher.group(1);
                    data.address.plz = matcher.group(2);
                    data.address.location = matcher.group(3);
                }
                continue;
            }
            er = FuzzySearch.extractOne("Firmenname", Arrays.asList(e.split(" ")));
            if (er.getScore() > 70 && er.getString().length() > 5) {
                i++;
                data.name = lines[i].replace(" ", "");
                continue;
            }
            if (data.TSN == null || data.TSN.equals("BPG")) {
                Pattern p = Pattern.compile("(\\d{1,4})\\s([\\w\\d]{3})[\\d]{5}");
                Matcher matcher = p.matcher(e);
                while (matcher.find()) {
                    data.HSN = matcher.group(1);
                    data.TSN = matcher.group(2);
                }
            }
        }
        return data;
    }

}
