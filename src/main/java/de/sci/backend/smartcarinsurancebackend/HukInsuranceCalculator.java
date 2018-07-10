package de.sci.backend.smartcarinsurancebackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.sci.backend.smartcarinsurancebackend.hukapi.HukApiCarInsuranceResult;
import de.sci.backend.smartcarinsurancebackend.hukapi.HukApiCarTypeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class HukInsuranceCalculator {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private String jwtApiKey;

    private static final String JWT_URL = "https://www.huk.de/api/auth/webtoken";
    private static final String API_URL = "https://www.huk.de/pkw/api/tarifiere";
    private static final String CAR_URL = "https://www.huk.de/pkw/api/vehicles";

    @PostConstruct
    public void init() {
        this.refreshApiToken();
    }

    /**
     * Update the token every 45 minutes (-> 2700000 miliseconds)
     */
    @Scheduled(fixedRate = 2700000)
    public void refreshApiToken() {
        ResponseEntity<ObjectNode> respEntity = restTemplate.getForEntity(JWT_URL, ObjectNode.class);
        this.jwtApiKey = respEntity.getBody().get("jsonWebToken").asText();
        System.out.println("### API TOKEN GOT REFRESHED: " + respEntity.getBody().get("jsonWebToken").textValue());
    }

    public HukApiCarInsuranceResult getApiResultFromHuk(String hsn, String tsn) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", this.jwtApiKey);
        HttpEntity<ObjectNode> entity = new HttpEntity<ObjectNode>(getApiRequestObject(hsn, tsn), headers);
        ResponseEntity<HukApiCarInsuranceResult> respEntity = restTemplate.exchange(API_URL, HttpMethod.POST, entity, HukApiCarInsuranceResult
                .class);

        return respEntity.getBody();
    }

    public CarType getCarType(String hsn, String tsn) {

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.set("Authorization", this.jwtApiKey);
            HttpEntity<Object> entity = new HttpEntity<Object>(null, headers);

            Map<String, String> uriVariables = new HashMap<>();
            uriVariables.put("producerNumber", hsn);
            uriVariables.put("typeNumber", tsn);

            ResponseEntity<HukApiCarTypeResult> respEntity = restTemplate.exchange(CAR_URL + "?producerNumber=" + hsn +
                            "&typeNumber=" + tsn,
                    HttpMethod.GET, entity,
                    HukApiCarTypeResult
                            .class);

            String carTypeResultString = respEntity.getBody().getLabel();

            CarType result = new CarType();
            result.setHersteller(respEntity.getBody().getBrand());
            result.setHubraum(Integer.valueOf(carTypeResultString.split(",")[2].split(" ccm")[0].replace(" ", "")));
            result.setLeistung(Integer.valueOf(carTypeResultString.split(",")[1].split(" PS")[0].replace(" ", "")));
            result.setTyp(carTypeResultString.split("-")[1].split(",")[0]);

            return result;

        } catch (Exception e ){
            System.out.println(e.getMessage());
            return defaultCarType();
        }

    }

    public CarType defaultCarType() {
        CarType result = new CarType();
        result.setHersteller("VW");
        result.setHubraum(1474);
        result.setLeistung(90);
        result.setTyp("Golf");
        return result;
    }

    private ObjectNode getApiRequestObject(String hsn, String tsn) throws Exception {

        ObjectNode result = objectMapper.createObjectNode();

        result.put("begin", "2018-08-01");
        result.put("dateOfBirth", "1990-11-11");
        result.put("vorgang", 2);
        result.put("geschlecht", 1);
        result.put("zahlweise", 1);
        result.put("produktlinie", "C");
        result.put("haftpflicht", 1);

        ObjectNode kasko = objectMapper.createObjectNode();
        kasko.put("vollkaskoAuswahl", false);
        kasko.put("teilkaskoAuswahl", false);
        kasko.put("teilkaskoSelbstbeteiligung", 6);
        kasko.put("vollkaskoSelbstbeteiligung", 36);
        kasko.put("kaskoPlus", false);
        kasko.put("kaskoSelect", true);

        result.set("kasko", kasko);

        ObjectNode sfKlasse = objectMapper.createObjectNode();
        sfKlasse.put("klasseHaftpflicht", "35");
        sfKlasse.put("klasseKasko", "35");
        sfKlasse.put("vorversichert", false);
        result.set("sfKlasse", sfKlasse);

        ObjectNode eigentum = objectMapper.createObjectNode();
        eigentum.put("art", 3);
        eigentum.put("versichert", true);
        result.set("eigentum", eigentum);

        ObjectNode fahrzeug = objectMapper.createObjectNode();
        fahrzeug.put("erstZulassung", "2018-07-01");
        fahrzeug.put("finanzierung", 0);
        fahrzeug.put("hsn", hsn);
        fahrzeug.put("tsn", tsn);

        ObjectNode halter = objectMapper.createObjectNode();
        halter.put("typ", 0);
        ObjectNode halterAddress = objectMapper.createObjectNode();
        halterAddress.put("city", "Coburg");
        halterAddress.put("postalCode", "96450");
        halter.set("halterAddress", halterAddress);
        fahrzeug.set("halter", halter);

        fahrzeug.put("jaehrlFahrleistung", 7);
        fahrzeug.put("stellplatz", 1);
        fahrzeug.put("nutzung", 1);
        fahrzeug.put("nutzung", 1);
        fahrzeug.put("halterZulassung", "2018-08-01");
        fahrzeug.set("fahrertypes", objectMapper.createArrayNode());
        fahrzeug.set("fahrers", objectMapper.createArrayNode());
        result.set("fahrzeug", fahrzeug);

        ObjectNode berufgruppe = objectMapper.createObjectNode();
        berufgruppe.put("art", 5);
        berufgruppe.put("oedNoed", 1);
        berufgruppe.put("oeffentlDienstBranche", 6);
        result.set("berufGruppe", berufgruppe);

        return result;

    }
}
