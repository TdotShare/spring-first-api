package com.spring.first.api.spring_first_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hrss_directive_doc")
public class DirectiveDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directiveDocId") //
    private Integer directiveDocId;

    @Column(name = "directiveDocNumber") //
    private String directiveDocNumber;

    @Column(name = "directiveDocTypeId") //
    private Integer directiveDocTypeId;

    @Column(name = "directiveDocName") //
    private String directiveDocName;

    @Column(name = "directiveDocIssuedDate")
    private LocalDate directiveDocIssuedDate;

    @Column(name = "directiveDocStartDate")
    private LocalDate directiveDocStartDate;

    @Column(name = "directiveDocEndDate")
    private LocalDate directiveDocEndDate;

    @Column(name = "directiveDocFile")
    private String directiveDocFile;

    @Column(name = "directiveDocUsername")
    private String directiveDocUsername;

    @Column(name = "directiveDocCreateAt")
    private LocalDate directiveDocCreateAt;

    @Column(name = "directiveDocUpdateAt")
    private LocalDate directiveDocUpdateAt;

    public Integer getDirectiveDocId() {
        return directiveDocId;
    }

    public void setDirectiveDocId(Integer directiveDocId) {
        this.directiveDocId = directiveDocId;
    }

    public String getDirectiveDocNumber() {
        return directiveDocNumber;
    }

    public void setDirectiveDocNumber(String directiveDocNumber) {
        this.directiveDocNumber = directiveDocNumber;
    }

    public String getDirectiveDocName() {
        return directiveDocName;
    }

    public void setDirectiveDocName(String directiveDocName) {
        this.directiveDocName = directiveDocName;
    }

    public LocalDate getDirectiveDocIssuedDate() {
        return directiveDocIssuedDate;
    }

    public void setDirectiveDocIssuedDate(LocalDate directiveDocIssuedDate) {
        this.directiveDocIssuedDate = directiveDocIssuedDate;
    }

    public LocalDate getDirectiveDocStartDate() {
        return directiveDocStartDate;
    }

    public void setDirectiveDocStartDate(LocalDate directiveDocStartDate) {
        this.directiveDocStartDate = directiveDocStartDate;
    }

    public LocalDate getDirectiveDocEndDate() {
        return directiveDocEndDate;
    }

    public void setDirectiveDocEndDate(LocalDate directiveDocEndDate) {
        this.directiveDocEndDate = directiveDocEndDate;
    }

    public String getDirectiveDocFile() {
        return directiveDocFile;
    }

    public void setDirectiveDocFile(String directiveDocFile) {
        this.directiveDocFile = directiveDocFile;
    }

    public String getDirectiveDocUsername() {
        return directiveDocUsername;
    }

    public void setDirectiveDocUsername(String directiveDocUsername) {
        this.directiveDocUsername = directiveDocUsername;
    }

    public LocalDate getDirectiveDocCreateAt() {
        return directiveDocCreateAt;
    }

    public void setDirectiveDocCreateAt(LocalDate directiveDocCreateAt) {
        this.directiveDocCreateAt = directiveDocCreateAt;
    }

    public LocalDate getDirectiveDocUpdateAt() {
        return directiveDocUpdateAt;
    }

    public void setDirectiveDocUpdateAt(LocalDate directiveDocUpdateAt) {
        this.directiveDocUpdateAt = directiveDocUpdateAt;
    }

    // Constructor
    public DirectiveDoc() {
    }

}