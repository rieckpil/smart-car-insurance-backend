package de.sci.backend.smartcarinsurancebackend;

import lombok.Data;

@Data
public class CarType {

    private String hersteller;
    private int leistung;
    private String typ;
    private int hubraum;

}
