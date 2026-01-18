package com.spring.first.api.spring_first_api.service;
import org.springframework.stereotype.Service;

import com.spring.first.api.spring_first_api.repository.UserRepository;

@Service
public class HomeServiceImpl implements HomeService {

    private final UserRepository userRepository;

    public HomeServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String getHello(String name) {
        String _name = name;
        return "Hello : " + _name; 
    }

    @Override
    public String checkDatabase() {
        try {
            // วิธีทดสอบที่ง่ายที่สุดคือการลองนับ record ใน table
            long count = userRepository.count(); 
            return "Database Connection Success! Total users in DB: " + count;
        } catch (Exception e) {
            // ถ้าเชื่อมต่อไม่ได้ หรือ Table ไม่มีอยู่จริง จะตกมาที่นี่
            return "Database Connection Failed: " + e.getMessage();
        }
    }
}
