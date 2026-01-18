package com.spring.first.api.spring_first_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.first.api.spring_first_api.model.DirectiveDoc;
import com.spring.first.api.spring_first_api.repository.DirectiveDocRepository;

@Service
public class DirectiveDocServiceImpl implements DirectiveDocService {

    private final DirectiveDocRepository directiveDocRepository;

    public DirectiveDocServiceImpl(DirectiveDocRepository directiveDocRepository) {
        this.directiveDocRepository = directiveDocRepository;
    }

    @Override
    public List<DirectiveDoc> getDirectiveDocAll() {
        try {
            List<DirectiveDoc> directiveDocList = directiveDocRepository.findAll();

            return directiveDocList;

        } catch (Exception e) {
            throw new RuntimeException("Error fetching all directive docs: " + e.getMessage());
        }
    }

}
