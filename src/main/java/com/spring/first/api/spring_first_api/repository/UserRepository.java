package com.spring.first.api.spring_first_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.first.api.spring_first_api.model.User;

public interface UserRepository extends JpaRepository<User , Integer> {
    
}
