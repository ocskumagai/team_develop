package com.example.demo.controller;

import com.example.demo.dto.IntroductionForm;
import com.example.demo.model.IntroductionEntity;
import com.example.demo.repository.IntroductionRepository;
import com.example.demo.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConfirmController {
    @Autowired
    IntroductionService introductionService;

    @PostMapping("/confirm/complete")
    public String createIntroduction(IntroductionForm introductionForm, Model model) {
        //ユーザーIDを取得する
        final String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        //自己紹介の登録情報を保存
            introductionService.InputData(introductionForm);
            //ユーザーIDで検索
            IntroductionEntity newUserInfo = introductionService.searchUserId(userId);
            //Viewに入力情報を返す
            model.addAttribute("introductionForm", introductionForm);
            // view に管理番号を返す
            model.addAttribute("id", newUserInfo.getIntroductionId());
            return "complete";
    }

    //入力フォームに戻る
    @PostMapping("/confirm/introduce")
    public String goBack(IntroductionForm introductionForm) {
        return "introduction";
    }
}