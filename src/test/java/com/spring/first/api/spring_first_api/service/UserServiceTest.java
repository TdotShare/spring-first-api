package com.spring.first.api.spring_first_api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.first.api.spring_first_api.dto.UserCampusDTO;
import com.spring.first.api.spring_first_api.dto.UserRoleView;
import com.spring.first.api.spring_first_api.dto.UserShortInfoView;
import com.spring.first.api.spring_first_api.model.User;
import com.spring.first.api.spring_first_api.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository; // Mock Repository ที่ Service เรียกใช้

    @InjectMocks
    private UserServiceImpl userService; // ฉีด Mock เข้าไปใน Service

    private User mockUser;

    @BeforeEach
    void setUp() {
        mockUser = new User();
        mockUser.setUserId(1);
        mockUser.setUserUsername("test_user");
    }

    @Test
    @DisplayName("ทดสอบค้นหา User ด้วย Username")
    void testFindByUserUsername_Success() {
        // Arrange
        when(userRepository.findByUserUsername("test_user")).thenReturn(Optional.of(mockUser));

        // Act
        Optional<User> result = userService.findByUserUsername("test_user");

        // Assert
        assertTrue(result.isPresent());
        assertEquals("test_user", result.get().getUserUsername());
        verify(userRepository, times(1)).findByUserUsername("test_user");
    }

    @Test
    @DisplayName("ทดสอบดึงข้อมูล User แบบ Projection (UserRoleView)")
    void testFindProjectedByUserUsername_Success() {
        // Arrange: สร้าง Mock สำหรับ Interface Projection
        UserRoleView mockRoleView = Mockito.mock(UserRoleView.class);
        when(userRepository.findProjectedByUserUsername("test_user")).thenReturn(Optional.of(mockRoleView));

        // Act
        Optional<UserRoleView> result = userService.findProjectedByUserUsername("test_user");

        // Assert
        assertTrue(result.isPresent());
        assertNotNull(result.get());
    }

    @Test
    @DisplayName("ทดสอบดึงข้อมูล UserCampusDTO ทั้งหมด")
    void testFindAllUserCampus_Success() {
        // Arrange
        UserCampusDTO dto = new UserCampusDTO(1, "test_user", "101", "BKK");
        when(userRepository.findAllUserCampus()).thenReturn(Arrays.asList(dto));

        // Act
        List<UserCampusDTO> result = userService.findAllUserCampus();

        // Assert
        assertEquals(1, result.size());
        assertEquals("BKK", result.get(0).getCampusShortName());
    }

    @Test
    @DisplayName("ทดสอบการเรียก Stored Procedure ผ่าน Service")
    void testSpGetUserById_Success() {
        // Arrange
        UserShortInfoView mockShortInfo = Mockito.mock(UserShortInfoView.class);
        when(mockShortInfo.getUserId()).thenReturn(1);
        when(userRepository.sp_getUserById(1)).thenReturn(Arrays.asList(mockShortInfo));

        // Act
        List<UserShortInfoView> result = userService.sp_getUserById(1);

        // Assert
        assertFalse(result.isEmpty());
        assertEquals(1, result.get(0).getUserId());
        verify(userRepository, times(1)).sp_getUserById(1);
    }
}