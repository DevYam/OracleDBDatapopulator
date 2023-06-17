package com.devyam.datapopulator;

import com.devyam.datapopulator.service.DataPopulateService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class DataPopulateApplication implements CommandLineRunner {

    @Autowired
    private DataPopulateService dataPopulateService;

    public static void main(String[] args) {
        SpringApplication.run(DataPopulateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting to populate data");
        int numberOfRows = 10000;
        boolean status = dataPopulateService.populateRandomShipmentData(numberOfRows);
        if (status)
            log.info("{} rows of data populated successfully", numberOfRows);
        else
            log.info("Cannot populate data");
    }
}
