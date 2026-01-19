package com.spring.first.api.spring_first_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "elv_role_system")
public class RoleSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private Integer roleId;

    @Column(name = "roleCode")
    private String roleCode;

    @Column(name = "roleNameTH")
    private String roleNameTH;

    @Column(name = "roleNameEN")
    private String roleNameEN;

    @Column(name = "roleCreateAt")
    private LocalDateTime roleCreateAt;

    @Column(name = "roleUpdateAt")
    private LocalDateTime roleUpdateAt;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleNameTH() {
        return roleNameTH;
    }

    public void setRoleNameTH(String roleNameTH) {
        this.roleNameTH = roleNameTH;
    }

    public String getRoleNameEN() {
        return roleNameEN;
    }

    public void setRoleNameEN(String roleNameEN) {
        this.roleNameEN = roleNameEN;
    }

    public LocalDateTime getRoleCreateAt() {
        return roleCreateAt;
    }

    public void setRoleCreateAt(LocalDateTime roleCreateAt) {
        this.roleCreateAt = roleCreateAt;
    }

    public LocalDateTime getRoleUpdateAt() {
        return roleUpdateAt;
    }

    public void setRoleUpdateAt(LocalDateTime roleUpdateAt) {
        this.roleUpdateAt = roleUpdateAt;
    }

}
