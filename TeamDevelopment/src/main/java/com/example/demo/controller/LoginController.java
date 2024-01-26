package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpSession session;
    @GetMapping("/login")
    public String displayLogin(@ModelAttribute UserRequest userRequest) {
        return "login";
    }

//    エラーがあった場合このメソッドが呼び出される
    @GetMapping(value = "/login", params = "error")
    public String viewWithError(Model model, @ModelAttribute UserRequest userRequest) {
//        sessionからエラーメッセージを取得する
        var errorInfo = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        model.addAttribute("error", errorInfo.getMessage());
        return "login";
    }

    @GetMapping("/register")
    public String displayRegister(@ModelAttribute UserRequest userRequest) {
        return "register";
    }
    @PostMapping("/login")
    public String login(UserRequest userRequest, Model model) {
        var userInfo = userService.searchId(userRequest.getUserid());
        var isCorrectUserAuth = userInfo.isPresent()
                && userRequest.getPassword().equals(userInfo.get().getPassword());
        //ユーザー情報が取得できなかった場合;
        //入力値とデータベースの情報が一致した場合、トップ画面に遷移する
        if (isCorrectUserAuth) {
            return "redirect:/top";
        } else {
            String error = "パスワードが間違っています";
            model.addAttribute("error", error);
            return "login";
        }
    }
}