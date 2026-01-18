package com.spring.first.api.spring_first_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hrss_development_type")
public class DevelopmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer develTypeId;

    private String develTypeName;
    private Integer develTypeActive;

    // Constructor
    public DevelopmentType() {}

    // Getter & Setter
    public Integer getDevelTypeId() {
        return develTypeId;
    }

    public void setDevelTypeId(Integer develTypeId) {
        this.develTypeId = develTypeId;
    }

    public String getDevelTypeName() {
        return develTypeName;
    }

    public void setDevelTypeName(String develTypeName) {
        this.develTypeName = develTypeName;
    }

    public Integer getDevelTypeActive() {
        return develTypeActive;
    }

    public void setDevelTypeActive(Integer develTypeActive) {
        this.develTypeActive = develTypeActive;
    }
}