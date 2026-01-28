package com.spring.first.api.spring_first_api.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.first.api.spring_first_api.dto.UserShortInfoView;
import com.spring.first.api.spring_first_api.model.User;
import com.spring.first.api.spring_first_api.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService; // Mock Service

    @Test
    @DisplayName("ทดสอบการดึงข้อมูล User ผ่าน Stored Procedure")
    void testSpGetUserById_Success() throws Exception {
        // Arrange: สร้าง Mock สำหรับ Interface Projection
        UserShortInfoView mockView = Mockito.mock(UserShortInfoView.class);
        when(mockView.getUserId()).thenReturn(1);
        when(mockView.getUserUsername()).thenReturn("testuser");

        List<UserShortInfoView> mockList = Arrays.asList(mockView);
        
        // เมื่อเรียก service.sp_getUserById(1) ให้คืนค่า mockList
        when(userService.sp_getUserById(1)).thenReturn(mockList);

        // Act & Assert
        mockMvc.perform(get("/user/sp_getUserById/1") //
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId").value(1))
                .andExpect(jsonPath("$[0].userUsername").value("testuser"));
    }

    @Test
    @DisplayName("ทดสอบค้นหา User ด้วย Username - กรณีพบข้อมูล")
    void testFindByUserUsername_Found() throws Exception {
        // Arrange
        User user = new User(); //
        user.setUserId(1);
        user.setUserUsername("john_doe");

        when(userService.findByUserUsername("john_doe")).thenReturn(Optional.of(user));

        // Act & Assert
        mockMvc.perform(get("/user/findByUserUsername") //
                .param("username", "john_doe")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userUsername").value("john_doe"));
    }

    @Test
    @DisplayName("ทดสอบค้นหา User ด้วย Username - กรณีไม่พบข้อมูล")
    void testFindByUserUsername_NotFound() throws Exception {
        // Arrange
        when(userService.findByUserUsername("unknown")).thenReturn(Optional.empty());

        // Act & Assert
        mockMvc.perform(get("/user/findByUserUsername")
                .param("username", "unknown"))
                .andExpect(status().isNotFound()); //
    }
}