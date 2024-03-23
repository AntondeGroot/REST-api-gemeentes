package com.municipality.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.municipality.restapi.entities.Municipality;
import com.municipality.restapi.repository.MunicipalityRepository;

@RestController
@RequestMapping("/v1/gemeenten")
public class MunicipalityController {

    @Autowired
    private MunicipalityRepository repository;
    
    @GetMapping()
    public List<Municipality> retrieveAllMunicipalities(
        @RequestParam(defaultValue = "gemeente") String sort_by,
        @RequestParam(defaultValue = "asc") String order_by){

        Sort.Direction sortDirection = "asc".equalsIgnoreCase(order_by) ? Sort.Direction.ASC : Sort.Direction.DESC;
        return repository.findAll(Sort.by(sortDirection, sort_by));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipality> retrieveMunicipalityById(@PathVariable long id){
        return repository.findById(id)
                .map(municipality -> ResponseEntity.ok().body(municipality))
                .orElse(ResponseEntity.notFound().build());
    }
}
