package com.spring.first.api.spring_first_api.service;

import java.util.Optional;

import com.spring.first.api.spring_first_api.dto.UserRoleView;
import com.spring.first.api.spring_first_api.model.User;

public interface UserService {
    Optional<User> findByUserUsername(String username);
    Optional<UserRoleView> findProjectedByUserUsername(String username);
}