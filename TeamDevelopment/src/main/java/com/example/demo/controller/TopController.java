package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.example.demo.constant.UrlConst.TOP;

@Controller
public class TopController {
    //top画面を表示
    @GetMapping(TOP)
    public String displayTop() {
        return "top";
    }

    //ログアウトを行うメソッド
    @GetMapping("/logout")
    public String backToLogin() {
        return "login";
    }
}
