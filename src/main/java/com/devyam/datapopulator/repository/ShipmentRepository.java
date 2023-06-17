package com.devyam.datapopulator.repository;

import com.devyam.datapopulator.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
