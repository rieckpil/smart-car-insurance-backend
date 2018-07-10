package de.sci.backend.smartcarinsurancebackend;

import lombok.Data;

@Data
public class CarInsuranceResult {

    private String name;
    private String stadt;
    private String strasse;
    private String plz;
    private String hersteller;
    private String typ;
    private int leistung;
    private double haftpflicht;
    private double vollkasko;
    private double teilkasko;

}
