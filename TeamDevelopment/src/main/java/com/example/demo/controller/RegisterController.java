package com.example.demo.controller;
import com.example.demo.controller.LoginController;
import com.example.demo.dto.UserRequest;
import com.example.demo.model.UserEntity;
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
        //データベースからユーザーIDの一致するレコードを取得
        UserEntity user = userService.searchId(userRequest.getUserid());
        //バリデーションチェック
       if (result.hasErrors()) {
            return "register";
        //ユーザーIDが重複していなければデータベースに保存
        }else if(user == null) {
           userService.DataInput(userRequest);
           return "redirect:/login";
       }else {
           String unFindError = "そのユーザーIDはすでに登録されています";
           model.addAttribute("unFindError" , unFindError);
           return "register";
       }
    }
}