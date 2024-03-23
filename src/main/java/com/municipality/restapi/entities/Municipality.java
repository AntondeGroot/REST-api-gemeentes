package com.municipality.restapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="municipalities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String gemeente;
    @Column(name="province")
    private String provincie;
    @Column(name="inhabitants")
    private int inwoners;

    @Override
    public String toString() {
        return "Municipality [name=" + gemeente + ", province=" + provincie + ", inhabitants=" + inwoners + "]";
    }    
}
