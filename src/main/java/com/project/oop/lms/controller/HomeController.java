package com.project.oop.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Hứng đường dẫn gốc http://localhost:8080/
    public String index() {
        return "index"; // Trỏ đến file templates/index.html
    }
}
