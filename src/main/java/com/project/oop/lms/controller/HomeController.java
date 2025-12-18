package com.project.oop.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller 
public class HomeController {

    // Trang chủ hệ thống
 
     // URL: http://localhost:8080/
    @GetMapping("/") 
    public String index(Model model) {

       
        return "index";
    }
     // Trang giới thiệu 
   
     // URL: http://localhost:8080/about
    @GetMapping("/about") 
    public String about() {

        // Trả về trang about (templates/about.html)
        return "about";
    }
}
