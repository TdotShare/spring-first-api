package com.spring.first.api.spring_first_api.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.first.api.spring_first_api.dto.DirectiveDocDTO;
import com.spring.first.api.spring_first_api.model.DirectiveDoc;
import com.spring.first.api.spring_first_api.service.DirectiveDocService;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(DircetiveDocController.class) // ทดสอบเฉพาะ Controller ตัวนี้
public class DirectiveDocControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DirectiveDocService directiveDocService; // Mock ตัว Service

    private DirectiveDoc mockDoc;
    private DirectiveDocDTO mockDto;

    @BeforeEach
    void setUp() {
        // เตรียมข้อมูลจำลองสำหรับ Model
        mockDoc = new DirectiveDoc();
        mockDoc.setDirectiveDocId(1);
        mockDoc.setDirectiveDocName("Test Document");

        // เตรียมข้อมูลจำลองสำหรับ DTO
        mockDto = new DirectiveDocDTO();
        // สมมติว่า DTO มี field เหล่านี้ (ปรับตาม DTO จริงของคุณ)
        // mockDto.setDirectiveDocId(1);
        // mockDto.setDirectiveDocName("Test Document DTO");
    }

    @Test
    void testGetDirectiveDocAll_Success() throws Exception {
        // Arrange: เมื่อเรียก getDirectiveDocAll ให้คืนค่า List ของ DTO
        List<DirectiveDocDTO> allDocs = Arrays.asList(mockDto);
        when(directiveDocService.getDirectiveDocAll()).thenReturn(allDocs);

        // Act & Assert
        mockMvc.perform(get("/dircetiveDoc/getDirectiveDocAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // ตรวจสอบว่า HTTP Status คือ 200 OK
                .andExpect(jsonPath("$.length()").value(1)); // ตรวจสอบว่า Array ที่ส่งกลับมามีขนาด 1
    }

    @Test
    void testGetDirectiveId_Success() throws Exception {
        // Arrange: เมื่อเรียก getDirectiveId(1) ให้คืนค่า Optional ของ mockDoc
        when(directiveDocService.getDirectiveId(1)).thenReturn(Optional.of(mockDoc));

        System.out.println("test testGetDirectiveId_Success !");
        // Act & Assert
        mockMvc.perform(get("/dircetiveDoc/getDirectiveDoc/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directiveDocId").value(1))
                .andExpect(jsonPath("$.directiveDocName").value("Test Document"));
    }

    @Test
    void testGetDirectiveId_NotFound() throws Exception {
        // ในกรณีที่ Service โยน ResourceNotFoundException (ตามที่เขียนใน ServiceImpl)
        // MockMvc จะตรวจจับ Exception นั้น
        when(directiveDocService.getDirectiveId(99)).thenThrow(new RuntimeException("ไม่พบเอกสารรหัส: 99"));

        mockMvc.perform(get("/dircetiveDoc/getDirectiveDoc/99")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError()); // หรือ status อื่นๆ ตามที่ GlobalExceptionHandler
                                                              // จัดการไว้
    }

    @Test
    @DisplayName("กรณีส่ง ID เป็นตัวอักษร - ควรตอบกลับด้วย 400 Bad Request")
    void testGetDirectiveId_BadRequest_StringId() throws Exception {
        // เราส่ง "abc" แทนที่จะเป็นตัวเลข 1, 2, 3
        mockMvc.perform(get("/dircetiveDoc/getDirectiveDoc/abc")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()) // ช่วยแสดงรายละเอียด Request/Response ใน Debug Console
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("กรณีหาข้อมูลไม่พบ - ควรตอบกลับด้วย Exception ที่เรานิยามไว้")
    void testGetDirectiveId_NotFound_RealScenario() throws Exception {
        // Arrange: เมื่อเรียก ID 99 ให้โยน ResourceNotFoundException ตามที่มีใน
        // ServiceImpl
        int missingId = 99;
        when(directiveDocService.getDirectiveId(missingId))
                .thenThrow(new com.spring.first.api.spring_first_api.exception.ResourceNotFoundException(
                        "ไม่พบเอกสารรหัส: " + missingId));

        // Act & Assert
        mockMvc.perform(get("/dircetiveDoc/getDirectiveDoc/" + missingId))
                .andDo(print())
                // หมายเหตุ: ถ้ายังไม่ได้ทำ GlobalExceptionHandler จะได้ 500 หรือ 404
                // ขึ้นอยู่กับการตั้งค่า Spring
                .andExpect(status().isNotFound());
    }
}