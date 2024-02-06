package com.example.demo.controller;

import com.example.demo.dto.IntroductionForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IntroductionController {
    @PostMapping("/confirm")
    public String displayConfirmView(@Validated IntroductionForm introductionForm, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "introduction";
        }
        model.addAttribute("introductionForm",introductionForm);
        return "confirm";
    }
}
