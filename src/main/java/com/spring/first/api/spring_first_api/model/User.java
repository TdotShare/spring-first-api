package com.spring.first.api.spring_first_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "elv_user")
public class User {

    // --- Constructor ---
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId") //
    private Integer userId;

    @Column(name = "userUsername") //
    private String userUsername;

    @Column(name = "userEmail") //
    private String userEmail;

    @Column(name = "userFirstName") //
    private String userFirstName;

    @Column(name = "userLastName")
    private String userLastName;

    @Column(name = "userFirstNameEng")
    private String userFirstNameEng;

    @Column(name = "userFacultyCode")
    private Integer userFacultyCode;

    @Column(name = "userDepartmentCode")
    private Integer userDepartmentCode;

    @Column(name = "userPicture")
    private String userPicture;

    @Column(name = "userTel")
    private String userTel;

    @Column(name = "userMobile")
    private String userMobile;

    @Column(name = "userStatus")
    private Integer userStatus;

    @Column(name = "userCampusId")
    private String userCampusId;

    @Column(name = "userSignatureFileName")
    private String userSignatureFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userTypeId", referencedColumnName = "roleId", insertable = false, updatable = false)
    private RoleSystem role;

    @Column(name = "userTypeId") //
    private Integer userTypeId;

    @Column(name = "userCreateAt", updatable = false)
    private LocalDateTime userCreateAt;

    @Column(name = "userUpdateAt", updatable = false)
    private LocalDateTime userUpdateAt;

    @Column(name = "userLastLoginAt", updatable = false)
    private LocalDateTime userLastLoginAt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserFirstNameEng() {
        return userFirstNameEng;
    }

    public void setUserFirstNameEng(String userFirstNameEng) {
        this.userFirstNameEng = userFirstNameEng;
    }

    public Integer getUserFacultyCode() {
        return userFacultyCode;
    }

    public void setUserFacultyCode(Integer userFacultyCode) {
        this.userFacultyCode = userFacultyCode;
    }

    public Integer getUserDepartmentCode() {
        return userDepartmentCode;
    }

    public void setUserDepartmentCode(Integer userDepartmentCode) {
        this.userDepartmentCode = userDepartmentCode;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserCampusId() {
        return userCampusId;
    }

    public void setUserCampusId(String userCampusId) {
        this.userCampusId = userCampusId;
    }

    public String getUserSignatureFileName() {
        return userSignatureFileName;
    }

    public void setUserSignatureFileName(String userSignatureFileName) {
        this.userSignatureFileName = userSignatureFileName;
    }

    public RoleSystem getRole() {
        return role;
    }

    public void setRole(RoleSystem role) {
        this.role = role;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public LocalDateTime getUserCreateAt() {
        return userCreateAt;
    }

    public void setUserCreateAt(LocalDateTime userCreateAt) {
        this.userCreateAt = userCreateAt;
    }

    public LocalDateTime getUserUpdateAt() {
        return userUpdateAt;
    }

    public void setUserUpdateAt(LocalDateTime userUpdateAt) {
        this.userUpdateAt = userUpdateAt;
    }

    public LocalDateTime getUserLastLoginAt() {
        return userLastLoginAt;
    }

    public void setUserLastLoginAt(LocalDateTime userLastLoginAt) {
        this.userLastLoginAt = userLastLoginAt;
    }
}