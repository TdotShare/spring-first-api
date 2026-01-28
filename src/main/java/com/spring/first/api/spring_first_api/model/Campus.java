package com.spring.first.api.spring_first_api.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "elv_campus")
public class Campus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campusId")
    private Integer campusId;

    @Column(name = "campusName")
    private String campusName;

    @Column(name = "campusShortName")
    private String campusShortName;

    @Column(name = "campusUsernameId")
    private String campusUsernameId;

    @Column(name = "campusAddress")
    private String campusAddress;

    @Column(name = "campusCreateAt")
    private LocalDate campusCreateAt;

    @Column(name = "campusUpdateAt")
    private LocalDate campusUpdateAt;

}
