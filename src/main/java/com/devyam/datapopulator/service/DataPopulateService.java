package com.devyam.datapopulator.service;

import com.devyam.datapopulator.entity.Shipment;
import com.devyam.datapopulator.model.ShipmentModel;
import com.devyam.datapopulator.repository.ShipmentRepository;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Log4j2
public class DataPopulateService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public boolean populateRandomShipmentData(int length){
        List<Shipment> randomShipmentList = generateRandomShipmentData(length);
        try {
            log.info("Random shipment list is {}", randomShipmentList);
            List<Shipment> shipmentList = shipmentRepository.saveAll(randomShipmentList);
            log.info("saved to repo. ShipmentList size: {}", shipmentList.size());
            return true;
        } catch (Exception e){
            log.info("Some exception occurred: {}", e.getMessage(), e);
            return false;
        }
    }


    public List<Shipment> generateRandomShipmentData(int length){
        List<Shipment> shipmentList = new ArrayList<>();
        ShipmentModel shipmentModel = new ShipmentModel();
        Random random = new Random();
        Lorem loremIpsum = LoremIpsum.getInstance();
        for (int i=0; i<length; i++){
            int shipmentNumber = random.nextInt(999999);
            String shipFrom = loremIpsum.getCountry();
            String shipTo = loremIpsum.getCountry();
            String instructions = loremIpsum.getWords(10, 15);
            LocalDate createdAt = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 5))));
            LocalDate updatedAt = null;
            if (i%2==0){
                updatedAt = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 5))));
            }
            shipmentModel.setShipmentNumber(shipmentNumber);
            shipmentModel.setShipFrom(shipFrom);
            shipmentModel.setShipTo(shipTo);
            shipmentModel.setInstructions(instructions);
            shipmentModel.setCreatedDate(createdAt);
            shipmentModel.setUpdatedDate(updatedAt);

            ModelMapper modelMapper = new ModelMapper();
            Shipment shipment = modelMapper.map(shipmentModel, Shipment.class);
            shipmentList.add(shipment);
        }
        log.info("Length of final list is = {}", shipmentList.size() );
        return shipmentList;
    }
}
