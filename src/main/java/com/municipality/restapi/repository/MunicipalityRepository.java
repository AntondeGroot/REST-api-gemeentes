package com.municipality.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.municipality.restapi.entities.Municipality;

public interface MunicipalityRepository extends JpaRepository<Municipality,Long> {

}
