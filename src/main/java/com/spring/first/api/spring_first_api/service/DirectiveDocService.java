package com.spring.first.api.spring_first_api.service;

import java.util.List;
import java.util.Optional;

import com.spring.first.api.spring_first_api.dto.DirectiveDocDTO;
import com.spring.first.api.spring_first_api.model.DirectiveDoc;

public interface DirectiveDocService {
    public List<DirectiveDocDTO> getDirectiveDocAll();
    public Optional<DirectiveDoc> getDirectiveId(int id);
}
