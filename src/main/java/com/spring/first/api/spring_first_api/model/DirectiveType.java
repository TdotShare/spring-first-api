package com.spring.first.api.spring_first_api.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hrss_directive_type")
public class DirectiveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directiveTypeId")
    private Integer directiveTypeId;

    @Column(name = "directiveTypeName")
    private String directiveTypeName;

    @Column(name = "directiveTypeCreateAt")
    private LocalDate directiveTypeCreateAt;

    @Column(name = "directiveTypeUpdateAt")
    private LocalDate directiveTypeUpdateAt;

    public Integer getDirectiveTypeId() {
        return directiveTypeId;
    }

    public void setDirectiveTypeId(Integer directiveTypeId) {
        this.directiveTypeId = directiveTypeId;
    }

    public String getDirectiveTypeName() {
        return directiveTypeName;
    }

    public void setDirectiveTypeName(String directiveTypeName) {
        this.directiveTypeName = directiveTypeName;
    }

    public LocalDate getDirectiveTypeCreateAt() {
        return directiveTypeCreateAt;
    }

    public void setDirectiveTypeCreateAt(LocalDate directiveTypeCreateAt) {
        this.directiveTypeCreateAt = directiveTypeCreateAt;
    }

    public LocalDate getDirectiveTypeUpdateAt() {
        return directiveTypeUpdateAt;
    }

    public void setDirectiveTypeUpdateAt(LocalDate directiveTypeUpdateAt) {
        this.directiveTypeUpdateAt = directiveTypeUpdateAt;
    }

}
