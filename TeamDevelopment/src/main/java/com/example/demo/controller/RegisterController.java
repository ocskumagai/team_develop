package com.example.demo.controller;
import com.example.demo.controller.LoginController;
import com.example.demo.dto.UserRequest;
import com.example.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    //登録ボタンを押した時に実行される
    @PostMapping("/register/inputUser")
    public String createUser(@Validated UserRequest userRequest, BindingResult result, Model model) {
        //入力ミスがあった場合新規登録画面にエラー表示
       if (result.hasErrors()) {
            return "register";
        }
        //データベースに保存するメソッド
        userService.DateInput(userRequest);
        return "redirect:/login";
    }
}