package com.project.oop.lms.controller;

import com.project.oop.lms.entity.DocGia;
import com.project.oop.lms.service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doc-gia") // Đường dẫn gốc: localhost:8080/doc-gia
public class ReaderController {

    @Autowired
    private IReaderService readerService;

    // 1. Hiển thị danh sách độc giả (GET)
    // Truy cập: localhost:8080/doc-gia
    @GetMapping
    public String xemDanhSach(Model model) {
        // Lấy list từ Service bỏ vào cái túi 'model' để mang sang HTML
        model.addAttribute("danhSachDocGia", readerService.getAllDocGia());
        return "reader-list"; // Trả về file reader-list.html
    }

    // 2. Hiển thị Form thêm mới (GET)
    // Truy cập: localhost:8080/doc-gia/them
    @GetMapping("/them")
    public String hienThiFormThem(Model model) {
        DocGia docGiaMoi = new DocGia();
        model.addAttribute("docGia", docGiaMoi);
        return "reader-form"; // Trả về file reader-form.html
    }

    // 3. Xử lý nút LƯU (POST)
    @PostMapping("/luu")
    public String luuDocGia(@ModelAttribute("docGia") DocGia docGia) {
        // Logic kiểm tra: Nếu chưa có mã -> là Thêm mới. Nếu có mã -> là Sửa.
        
        if (docGia.getMaDocGia() == null || docGia.getMaDocGia().isEmpty()) {
            // Gọi service thêm mới
            readerService.themDocGia(docGia);
        } else {
            // Gọi service sửa
            // Lưu ý: Form chỉ gửi về các thông tin cơ bản, ở đây mình gọi hàm sửa
            readerService.suaThongTinDocGia(docGia.getMaDocGia(), docGia.getHoTen(), docGia.getSoDienThoai());
        }
        
        // Sau khi lưu xong, chuyển hướng về trang danh sách
        return "redirect:/doc-gia";
    }

    // 4. Hiển thị Form sửa thông tin (GET)
    // Truy cập: localhost:8080/doc-gia/sua/DG1234
    @GetMapping("/sua/{maDocGia}")
    public String hienThiFormSua(@PathVariable String maDocGia, Model model) {
        DocGia docGiaCanSua = readerService.timDocGiaTheoMa(maDocGia);
        
        if (docGiaCanSua != null) {
            model.addAttribute("docGia", docGiaCanSua);
            return "reader-form"; // Tái sử dụng form thêm để làm form sửa
        } else {
            return "redirect:/doc-gia";
        }
    }
    
    // 5. Test Check Hợp Lệ (Chạy thử trên trình duyệt)
    // Truy cập: localhost:8080/doc-gia/check/DG1234
    @GetMapping("/check/{maDocGia}")
    @ResponseBody // Trả về text trực tiếp, không qua file HTML (dùng để test nhanh)
    public String testCheckHopLe(@PathVariable String maDocGia) {
        boolean hopLe = readerService.checkDocGiaHopLe(maDocGia);
        return hopLe ? "Thẻ " + maDocGia + " HỢP LỆ (OK)" : "Thẻ " + maDocGia + " KHÔNG HỢP LỆ (BỊ KHÓA)";
    }
}
