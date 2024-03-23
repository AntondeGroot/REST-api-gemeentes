package com.municipality.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.municipality.restapi.entities.Province;

public interface ProvinceRepository extends JpaRepository<Province,Long> {

}
