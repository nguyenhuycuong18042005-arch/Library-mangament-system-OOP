package com.project.oop.lms.controller;

import org.springframework.ui.Model;
import com.project.oop.lms.entity.TacGia;
import com.project.oop.lms.entity.TaiKhoan;
import com.project.oop.lms.repository.DataStore;
import com.project.oop.lms.repository.LibraryData;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final DataStore dataStore;

    @GetMapping("/login")
    public String showLoginForm(HttpSession session){
        if(session.getAttribute("USER_LOGGED_IN") != null){
            return "redirect:/";
        }
        return "auth/login";
    }

    //xu ly dang nhap
    @PostMapping("/login")
    private String handleLogin(@RequestParam String username, @RequestParam String password,
                                HttpSession session, Model model){
        Optional<TaiKhoan> acc = dataStore.getData().getDsTaiKhoan().stream()
                .filter(u->u.getTenDangNhap().equals(username) && u.getMatKhau().equals(password))
                .findFirst();

        if(acc.isPresent()){
            TaiKhoan taiKhoan = acc.get();
            session.setAttribute("USER_LOGGED_IN", acc.get());
            return "redirect:/";
        }
        else{
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
            model.addAttribute("lastUsername", username);
            return "auth/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }


}
