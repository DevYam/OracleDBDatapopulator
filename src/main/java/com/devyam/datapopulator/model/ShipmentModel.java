package com.devyam.datapopulator.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ShipmentModel {
    private int shipmentNumber;
    private String shipFrom;
    private String shipTo;
    private String instructions;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}