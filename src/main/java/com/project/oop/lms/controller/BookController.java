package com.project.oop.lms.controller;

import com.project.oop.lms.entity.Sach;
import com.project.oop.lms.repository.LibraryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private LibraryData libraryData;

    // ---------------------------
    // 1. Danh sách đầu sách
    // ---------------------------
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", libraryData.getDsSach());
        return "book-list";
    }

    // ---------------------------
    // 2. Form thêm sách
    // ---------------------------
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Sach());
        return "book-form";
    }

    // ---------------------------
    // 3. Lưu sách mới
    // ---------------------------
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Sach sach) {

        // nếu ISBN đã tồn tại → cập nhật
        for (int i = 0; i < libraryData.getDsSach().size(); i++) {
            if (libraryData.getDsSach().get(i).getIsbn().equals(sach.getIsbn())) {
                libraryData.getDsSach().set(i, sach);
                return "redirect:/books";
            }
        }

        // nếu chưa tồn tại → thêm mới
        libraryData.getDsSach().add(sach);

        return "redirect:/books";
    }

    // ---------------------------
    // 4. Form sửa sách
    // ---------------------------
    @GetMapping("/edit/{isbn}")
    public String editBook(@PathVariable String isbn, Model model) {
        Sach target = null;

        for (Sach s : libraryData.getDsSach()) {
            if (s.getIsbn().equals(isbn)) {
                target = s;
                break;
            }
        }

        model.addAttribute("book", target);
        return "book-form";
    }

    // ---------------------------
    // 5. Xóa sách
    // ---------------------------
    @GetMapping("/delete/{isbn}")
    public String deleteBook(@PathVariable String isbn) {
        libraryData.getDsSach().removeIf(s -> s.getIsbn().equals(isbn));
        return "redirect:/books";
    }

    // ---------------------------
    // 6. Kho sách vật lý
    // ---------------------------
    @GetMapping("/inventory")
    public String viewInventory(Model model) {
        model.addAttribute("inventory", libraryData.getDsSachVatLy());
        return "book-inventory";
    }
}
