package com.spring.first.api.spring_first_api.dto;

import java.time.LocalDate;

public class DirectiveDocDTO {
    private Integer id;
    private String docNumber;
    private String docName;
    private String typeName; // มาจาก hrss_directive_type
    private LocalDate issuedDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String fileName;

    // Constructor เพื่อความสะดวกในการ Map ข้อมูล
    public DirectiveDocDTO(Integer id, String docNumber, String docName,
            String typeName, LocalDate issuedDate,
            LocalDate startDate, LocalDate endDate, String fileName) {
        this.id = id;
        this.docNumber = docNumber;
        this.docName = docName;
        this.typeName = typeName;
        this.issuedDate = issuedDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fileName = fileName;
    }

    public DirectiveDocDTO(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
