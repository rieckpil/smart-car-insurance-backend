package de.sci.backend.smartcarinsurancebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/insurance")
@CrossOrigin(origins = "*")
public class InsuranceBoundary {

    @Autowired
    private HukInsuranceCalculator hukInsuranceCalculator;

    @PostMapping
    public String calculateInsuranceCosts(@RequestParam("file") MultipartFile file) throws Exception {

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());

        byte[] imageBytes = file.getBytes();

        System.out.println("image has length of: " + imageBytes.length);

        return null;

    }

    @PostMapping("/dummy")
    public CarInsuranceResult getDummyCarInsuranceResult() {

        CarType defaultCarType = this.hukInsuranceCalculator.defaultCarType();

        CarInsuranceResult result = new CarInsuranceResult();
        result.setHaftpflicht(45.55);
        result.setTeilkasko(650.40);
        result.setVollkasko(993.60);
        result.setHersteller(defaultCarType.getHersteller());
        result.setTyp(defaultCarType.getTyp());
        result.setLeistung(defaultCarType.getLeistung());
        result.setName("Max Mustermann");
        result.setPlz("96450");
        result.setStadt("Coburg");
        result.setStrasse("Hauptstraße 10");

        return result;
    }

    @GetMapping("/cartype")
    public CarType getHukApiResult(@RequestParam("hsn") String hsn, @RequestParam("tsn") String tsn) throws Exception {

        return this.hukInsuranceCalculator.getCarType(hsn, tsn);

    }

}
