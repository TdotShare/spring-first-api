package com.spring.first.api.spring_first_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.first.api.spring_first_api.model.DirectiveDoc;

public interface DirectiveDocRepository extends JpaRepository<DirectiveDoc , Integer> {
    
}
