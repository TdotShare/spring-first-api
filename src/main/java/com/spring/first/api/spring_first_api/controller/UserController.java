package com.spring.first.api.spring_first_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.first.api.spring_first_api.dto.UserRoleView;
import com.spring.first.api.spring_first_api.model.User;
import com.spring.first.api.spring_first_api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findByUserUsername")
    public ResponseEntity<User> findByUserUsername(@RequestParam(value = "username", defaultValue = "") String name) {
        return userService.findByUserUsername(name)
                .map(user -> ResponseEntity.ok(user)) 
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findProjectedByUserUsername")
    public ResponseEntity<UserRoleView> findProjectedByUserUsername(@RequestParam(value = "username") String name) {
        return userService.findProjectedByUserUsername(name)
                .map(user -> ResponseEntity.ok(user)) // ถ้าเจอ ส่ง 200 OK พร้อมข้อมูล
                .orElseGet(() -> ResponseEntity.notFound().build()); // ถ้าไม่เจอ ส่ง 404 Not Found
    }
}
