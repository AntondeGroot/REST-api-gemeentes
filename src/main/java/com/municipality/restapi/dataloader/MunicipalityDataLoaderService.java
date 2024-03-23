package com.municipality.restapi.dataloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.municipality.restapi.entities.Municipality;
import com.municipality.restapi.repository.MunicipalityRepository;

import jakarta.annotation.PostConstruct;

@Service
public class MunicipalityDataLoaderService {
    private final MunicipalityRepository municipalityRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public MunicipalityDataLoaderService(MunicipalityRepository municipalityRepository, ObjectMapper objectMapper) {
        this.municipalityRepository = municipalityRepository;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadJsonData() {
        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data/gemeenten.json");
            List<Municipality> municipalities = objectMapper.readValue(inputStream, new TypeReference<List<Municipality>>() {});
            municipalityRepository.saveAll(municipalities);
        } catch (IOException e) {
            throw new RuntimeException("Error loading JSON data", e);
        }
    }
}
