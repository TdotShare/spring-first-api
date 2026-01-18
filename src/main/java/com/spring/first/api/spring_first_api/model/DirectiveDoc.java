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

    @Column(name = "directiveDocName") //
    private String directiveDocName;

    @Column(name = "directiveDocIssuedDate") //
    private LocalDate directiveDocIssuedDate;

    // Constructor
    public DirectiveDoc() {}

    // Getter & Setter
    public Integer getDirectiveDocId() { return directiveDocId; }
    public void setDirectiveDocId(Integer directiveDocId) { this.directiveDocId = directiveDocId; }

    public String getDirectiveDocNumber() { return directiveDocNumber; }
    public void setDirectiveDocNumber(String directiveDocNumber) { this.directiveDocNumber = directiveDocNumber; }

    public String getDirectiveDocName() { return directiveDocName; }
    public void setDirectiveDocName(String directiveDocName) { this.directiveDocName = directiveDocName; }

    public LocalDate getDirectiveDocIssuedDate() { return directiveDocIssuedDate; }
    public void setDirectiveDocIssuedDate(LocalDate directiveDocIssuedDate) { this.directiveDocIssuedDate = directiveDocIssuedDate; }
}