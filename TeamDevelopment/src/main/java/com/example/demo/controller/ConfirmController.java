package com.example.demo.controller;

import com.example.demo.dto.IntroductionForm;
import com.example.demo.repository.IntroductionRepository;
import com.example.demo.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConfirmController {
    @Autowired
    IntroductionService introductionService;

    @PostMapping("/confirm/complete")
    public String createIntroduction(IntroductionForm introductionForm, Model model) {
        introductionService.InputData(introductionForm);
        model.addAttribute("completeMsg", "登録が完了しました");
        return "confirm";
    }
}
