package com.project.oop.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/report")
public class ReportController {

    // TRANG CHỦ BÁO CÁO

    // URL : http://localhost:8080/report
    @GetMapping("")
    public String index() {

        // Trang này thường dùng để hiển thị menu báo cáo
        return "report/index";
    }

    // BÁO CÁO TỔNG QUAN

    // URL: http://localhost:8080/report/summary
    @GetMapping("/summary")
    public String summary(Model model) {

        // Controller trả về view hiển thị báo cáo tổng quan
        return "report/summary";
    }

    // BÁO CÁO SÁCH QUÁ HẠN

    // URL: http://localhost:8080/report/overdue
    @GetMapping("/overdue")
    public String overdue(Model model) {

         // Trả về view hiển thị danh sách sách quá hạn
        return "report/overdue";
    }
}
