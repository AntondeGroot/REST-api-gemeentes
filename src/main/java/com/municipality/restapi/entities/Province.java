package com.municipality.restapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="provinces")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Province {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String capital;
    private int surfaceArea;
    
    @Override
    public String toString() {
        return "Province [name=" + name + ", capital=" + capital + ", surfaceArea=" + surfaceArea + "]";
    }
}
