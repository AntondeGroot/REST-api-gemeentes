package com.municipality.restapi.dataloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.municipality.restapi.entities.Province;
import com.municipality.restapi.repository.ProvinceRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProvinceDataLoaderService {

    @Autowired
    private ProvinceRepository repository;

    @PostConstruct
    public void loadCSVIntoDatabase() throws IOException {
        String path = "/data/provincies.csv";
        try (InputStream is = getClass().getResourceAsStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            
            for (CSVRecord record : csvParser) {
                Province province = new Province();
                province.setName(record.get("PROVINCIE"));
                province.setCapital(record.get("HOOFDSTAD"));
                province.setSurfaceArea(Integer.valueOf(record.get("OPPERVLAKTE")));
                repository.save(province);
            }
        } catch (NullPointerException e) {
            throw new IOException("File not found in resources: " + path, e);
        }
    }
}
