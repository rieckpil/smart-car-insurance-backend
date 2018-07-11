package de.sci.backend.smartcarinsurancebackend;

import de.sci.backend.smartcarinsurancebackend.hukapi.HukApiCarInsuranceResult;
import de.sci.backend.smartcarinsurancebackend.hukapi.HukApiCarTypeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@RestController
@RequestMapping("/api/insurance")
@CrossOrigin(origins = "*")
public class InsuranceBoundary {

    @Autowired
    private HukInsuranceCalculator hukInsuranceCalculator;

    @Autowired
    private VehicleDocumentImageProcessor vehicleDocumentImageProcessor;

    @PostMapping
    public CarInsuranceResult calculateInsuranceCostsWithFormInBody(@RequestBody VehicleDocumentImage vehicleDocumentImage) throws
            Exception {

        byte[] decodedImage = Base64.getDecoder().decode(vehicleDocumentImage.getPicture());

        System.out.println("decoded images has " + decodedImage.length + " bytes");

        RegexParser.CarData data = this.vehicleDocumentImageProcessor.processImage(decodedImage);

        String hsn = data.getHSN();

        if (hsn.length() != 4) {
            int diff = 4 - hsn.length();
            for (int i = 0; i < diff; i++) {
                hsn = "0" + hsn;
            }
        }

        String tsn = data.getTSN().replace("O", "Q").replace("0", "Q");

        System.out.println("HSN: " + hsn);
        System.out.println("TSN: " + tsn);

        HukApiCarInsuranceResult hukCarInsuranceResult = this.hukInsuranceCalculator.getApiResultFromHuk(hsn, tsn);

        CarType carTypeResult = this.hukInsuranceCalculator.getCarType(hsn, tsn);

        CarInsuranceResult result = createCarInsuranceResult(hukCarInsuranceResult, carTypeResult, data);

        return result;
    }

    @PostMapping("/file")
    public CarInsuranceResult calculateInsuranceCostsWithFormFile(@RequestParam("file") MultipartFile file) throws
            Exception {

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());

        byte[] imageBytes = file.getBytes();

        System.out.println("image has length of: " + imageBytes.length);

        RegexParser.CarData data = this.vehicleDocumentImageProcessor.processImage(imageBytes);

        String hsn = data.getHSN();

        if (hsn.length() != 4) {
            int diff = 4 - hsn.length();
            for (int i = 0; i < diff; i++) {
                hsn = "0" + hsn;
            }
        }

        String tsn = data.getTSN().replace("O", "Q");

        System.out.println("HSN: " + hsn);
        System.out.println("TSN: " + tsn);

        HukApiCarInsuranceResult hukCarInsuranceResult = this.hukInsuranceCalculator.getApiResultFromHuk(hsn, tsn);

        CarType carTypeResult = this.hukInsuranceCalculator.getCarType(hsn, tsn);

        CarInsuranceResult result = createCarInsuranceResult(hukCarInsuranceResult, carTypeResult, data);

        return result;

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

        System.out.println(this.hukInsuranceCalculator.getApiResultFromHuk(hsn, tsn).toString());

        return this.hukInsuranceCalculator.getCarType(hsn, tsn);

    }


    private CarInsuranceResult createCarInsuranceResult(HukApiCarInsuranceResult hukCarInsuranceResult, CarType
            carTypeResult, RegexParser.CarData data) {

        CarInsuranceResult result = new CarInsuranceResult();

        result.setHaftpflicht(hukCarInsuranceResult.getBeitragHaftpflichtMitSchutzbrief());
        result.setTeilkasko(hukCarInsuranceResult.getBeitragTeilkasko());
        result.setVollkasko(hukCarInsuranceResult.getBeitragVollkasko());
        result.setHersteller(carTypeResult.getHersteller());
        result.setTyp(carTypeResult.getTyp());
        result.setLeistung(carTypeResult.getLeistung());
        result.setName(data.getSurname() + " " + data.getName());
        result.setPlz(data.getAddress().getPlz());
        result.setStadt(data.getAddress().getLocation());
        result.setStrasse(data.getAddress().getStreet());

        return result;
    }

}
