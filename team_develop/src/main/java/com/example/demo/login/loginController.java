package com.example.demo.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.UserBean;

@Controller
public class loginController {
//	初期画面
	@RequestMapping("login.html")
	public ModelAndView top(ModelAndView mv) {
		mv.setViewName("/login/login");
		return mv;
	}

//	登録画面に画面遷移
	@RequestMapping("register")
	public ModelAndView moveRegister(ModelAndView mv) {
		mv.setViewName("/register/register");
		return mv;

	}
	@RequestMapping(value = "/user-create" , method = RequestMethod.POST)
	public String userCreate(@Validated @ModelAttribute UserBean userBean, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}

		}
		return "add";

	}
}
