package com.spring.first.api.spring_first_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.first.api.spring_first_api.dto.DirectiveDocDTO;
import com.spring.first.api.spring_first_api.model.DirectiveDoc;

public interface DirectiveDocRepository extends JpaRepository<DirectiveDoc , Integer> {

   @Query("SELECT new com.spring.first.api.spring_first_api.dto.DirectiveDocDTO(" +
           "d.directiveDocId, d.directiveDocNumber, d.directiveDocName, " +
           "t.directiveTypeName, d.directiveDocIssuedDate, " +
           "d.directiveDocStartDate, d.directiveDocEndDate, d.directiveDocFile) " +
           "FROM DirectiveDoc d JOIN d.directiveType t") // เชื่อม table โดยใช้ความสัมพันธ์ ManyToOne
    List<DirectiveDocDTO> findAllDirectiveDTOs();
    
}
