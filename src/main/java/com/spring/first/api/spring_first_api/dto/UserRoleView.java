package com.spring.first.api.spring_first_api.dto;

public interface UserRoleView {
    Integer getUserId();
    String getUserUsername();
    
    // ใช้คำว่า get + ชื่อตัวแปรใน Entity (ซึ่งในที่นี้คือ role) + ชื่อฟิลด์ใน Role
    RoleInfo getRole();

    interface RoleInfo {
        Integer getRoleId();
        String getRoleNameTH();
    }
}
