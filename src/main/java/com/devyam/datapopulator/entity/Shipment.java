package com.devyam.datapopulator.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int shipmentNumber;
    private String shipFrom;
    private String shipTo;
    private String instructions;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
