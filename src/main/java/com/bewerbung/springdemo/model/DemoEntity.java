package com.bewerbung.springdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;

@Entity
@Getter
public class DemoEntity {

    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    private Long id;

    private String name;

    public DemoEntity(String name) {
        this.name = name;
    }

    public DemoEntity() {}
}