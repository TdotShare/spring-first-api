package com.spring.first.api.spring_first_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.first.api.spring_first_api.dto.DirectiveDocDTO;
import com.spring.first.api.spring_first_api.exception.ResourceNotFoundException;
import com.spring.first.api.spring_first_api.model.DirectiveDoc;
import com.spring.first.api.spring_first_api.repository.DirectiveDocRepository;

@Service
public class DirectiveDocServiceImpl implements DirectiveDocService {

    private final DirectiveDocRepository directiveDocRepository;

    public DirectiveDocServiceImpl(DirectiveDocRepository directiveDocRepository) {
        this.directiveDocRepository = directiveDocRepository;
    }

    @Override
    public List<DirectiveDocDTO> getDirectiveDocAll() {
        try {
            // เรียกใช้ Query ที่ Map เข้า DTO โดยตรง
            return directiveDocRepository.findAllDirectiveDTOs();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching directive DTOs: " + e.getMessage());
        }
    }

    @Override
    public Optional<DirectiveDoc> getDirectiveId(int id) {
        // ถ้าหาไม่เจอ ให้โยน Exception ที่เราสร้างขึ้นเอง
        return Optional.ofNullable(directiveDocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ไม่พบเอกสารรหัส: " + id)));
    }

}
