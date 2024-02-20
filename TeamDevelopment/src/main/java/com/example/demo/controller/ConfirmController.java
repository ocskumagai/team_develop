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
        final  String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        //データベースに保存
        introductionService.InputData(introductionForm);
        IntroductionEntity userInfo = introductionService.searchUserId(userId);
        model.addAttribute("introductionForm",introductionForm);
        model.addAttribute("id",userInfo.getIntroductionId());
        return "complete";
    }

    @PostMapping("/confirm/introduce")
    public String goBack(IntroductionForm introductionForm) {
        return "introduction";
    }
}
