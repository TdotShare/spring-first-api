package com.spring.first.api.spring_first_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "elv_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userUsername;
    private String userEmail;
    private String userFirstName;
    private String userLastName;

    @Column(updatable = false)
    private LocalDateTime userCreateAt;

    // --- Constructor ---
    public User() {
    }

    // --- Getter and Setter ---
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

    public LocalDateTime getUserCreateAt() {
        return userCreateAt;
    }

    public void setUserCreateAt(LocalDateTime userCreateAt) {
        this.userCreateAt = userCreateAt;
    }
}