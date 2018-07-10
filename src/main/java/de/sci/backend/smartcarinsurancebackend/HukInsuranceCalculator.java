package de.sci.backend.smartcarinsurancebackend;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class HukInsuranceCalculator {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private String jwtApiKey;

    private static final String JWT_URL = "https://www.huk.de/api/auth/webtoken";
    private static final String API_URL = "https://www.huk.de/pkw/api/tarifiere";

    /**
     * Update the token every 45 minutes (-> 2700000 miliseconds)
     */
    @Scheduled(fixedRate = 2700000)
    public void refreshApiToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.89 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<ObjectNode> respEntity = restTemplate.exchange(JWT_URL, HttpMethod.GET, entity, ObjectNode.class);
        this.jwtApiKey = respEntity.getBody().get("jsonWebToken").asText();

        System.out.println("### API TOKEN GOT REFRESHED: " + respEntity.getBody().get("jsonWebToken").textValue());
    }

    public HukApiResult getApiResultFromHuk(String hsn, String tsn) throws Exception{

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.89 Safari/537.36");
        headers.set("Authorization", this.jwtApiKey);
        HttpEntity<ObjectNode> entity = new HttpEntity<ObjectNode>(getApiRequestObject(hsn, tsn), headers);
        ResponseEntity<HukApiResult> respEntity = restTemplate.exchange(API_URL, HttpMethod.POST, entity, HukApiResult
                .class);

        return respEntity.getBody();
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
