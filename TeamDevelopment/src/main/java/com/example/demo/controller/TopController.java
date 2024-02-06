package com.example.demo.controller;

import com.example.demo.dto.IntroductionForm;
import com.example.demo.dto.UserRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import static com.example.demo.constant.UrlConst.TOP;

@Controller
public class TopController {
    //top画面を表示
    @GetMapping(TOP)
    public String displayTop() {
        return "top";
    }

    @GetMapping("/introduce")
    public String displayIntroduce(@ModelAttribute IntroductionForm introductionForm, Model model) {
        //ユーザーIDを取得するメソッド
        final  String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userId",name);
        return "introduction";
    }

    //ログアウトを行うメソッド
    @GetMapping("/logout")
    public String backToLogin() {
        return "login";
    }
}
