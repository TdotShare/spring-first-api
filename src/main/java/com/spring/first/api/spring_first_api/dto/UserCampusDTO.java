package com.spring.first.api.spring_first_api.dto;

public class UserCampusDTO {
    
    private Integer userId;
    private String userUsername;
    private String userCampusId;
    private String campusShortName;
    
    public UserCampusDTO(Integer userId, String userUsername, String userCampusId, String campusShortName) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userCampusId = userCampusId;
        this.campusShortName = campusShortName;
    }
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
    public String getUserCampusId() {
        return userCampusId;
    }
    public void setUserCampusId(String userCampusId) {
        this.userCampusId = userCampusId;
    }
    public String getCampusShortName() {
        return campusShortName;
    }
    public void setCampusShortName(String campusShortName) {
        this.campusShortName = campusShortName;
    }
}
