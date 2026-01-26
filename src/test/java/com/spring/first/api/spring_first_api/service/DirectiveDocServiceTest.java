package com.spring.first.api.spring_first_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.first.api.spring_first_api.exception.ResourceNotFoundException;
import com.spring.first.api.spring_first_api.model.DirectiveDoc;
import com.spring.first.api.spring_first_api.repository.DirectiveDocRepository;

@ExtendWith(MockitoExtension.class)
public class DirectiveDocServiceTest {

    @Mock 
    private DirectiveDocRepository directiveDocRepository;

    @InjectMocks
    private DirectiveDocServiceImpl directiveDocService;

    private DirectiveDoc mockDoc;

    @BeforeEach
    void setUp() {
        mockDoc = new DirectiveDoc();
        mockDoc.setDirectiveDocId(1);
        mockDoc.setDirectiveDocName("Test Document");
    }

    @Test
    void testGetDirectiveId_Success() {
        // 1. Arrange: กำหนดว่าถ้าเรียก findById(1) ให้คืนค่า mockDoc
        when(directiveDocRepository.findById(1)).thenReturn(Optional.of(mockDoc));

        // 2. Act: เรียกใช้ Service
        Optional<DirectiveDoc> result = directiveDocService.getDirectiveId(1);

        // 3. Assert: ตรวจสอบผลลัพธ์
        assertTrue(result.isPresent());
        assertEquals("Test Document", result.get().getDirectiveDocName());
    }

    @Test
    void testGetDirectiveId_NotFound_ShouldThrowException() {
        // Arrange: คืนค่าว่างเปล่า
        when(directiveDocRepository.findById(99)).thenReturn(Optional.empty());

        // Act & Assert: ตรวจสอบว่าโยน Exception ถูกต้องไหม
        assertThrows(ResourceNotFoundException.class, () -> {
            directiveDocService.getDirectiveId(99);
        });
    }
}