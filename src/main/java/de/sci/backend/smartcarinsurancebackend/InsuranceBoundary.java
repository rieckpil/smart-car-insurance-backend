package de.sci.backend.smartcarinsurancebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/insurance")
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

    @GetMapping
    public HukApiResult getHukApiResult(@RequestParam("hsn") String hsn, @RequestParam("tsn") String tsn) throws Exception {

        return this.hukInsuranceCalculator.getApiResultFromHuk(hsn, tsn);

    }

}
