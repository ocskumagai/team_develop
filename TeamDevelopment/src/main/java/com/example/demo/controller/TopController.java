package com.example.demo.controller;

import com.example.demo.dto.IntroductionForm;
import com.example.demo.dto.UserRequest;
import com.example.demo.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import static com.example.demo.constant.UrlConst.TOP;

@Controller
public class TopController {

    @Autowired
    IntroductionService introductionService;

    //top画面を表示
    @GetMapping(TOP)
    public String displayTop() {
        return "top";
    }

    // Todo: 既に自己紹介登録のデータが存在する場合、画面遷移できないようにする。
    //自己紹介の登録がない場合、登録画面に画面遷移
    @GetMapping("/introduce")
    public String displayIntroduce(@ModelAttribute IntroductionForm introductionForm, Model model) {
        //ユーザーIDを取得
        final String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        //自己紹介登録が既に保存されているか確認
        var userInfo = introductionService.doubleCheck(userId);
        //自己紹介登録が保存されていない場合、登録画面に画面遷移
        if (userInfo == null) {
            return "introduction";
        }
        model.addAttribute("duplication", "既に自己紹介を登録済みです");
        return "top";
    }

    //ログアウトを行うメソッド
    @GetMapping("/logout")
    public String backToLogin() {
        return "login";
    }
}
