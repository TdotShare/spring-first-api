package com.spring.first.api.spring_first_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.first.api.spring_first_api.service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {

    // 1. ประกาศตัวแปร interface เป็น final
    private final HomeService homeService;

    // 2. สร้าง Constructor เพื่อรับ HomeService (Spring จะส่ง HomeServiceImpl มาให้เอง)
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/getHello")
    public String getHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return homeService.getHello(name);
    }

    // 4. เพิ่ม API สำหรับเช็ค Database
    @GetMapping("/check-db")
    public String checkDb() {
        return homeService.checkDatabase();
    }
}
