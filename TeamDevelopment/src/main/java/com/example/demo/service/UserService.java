package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.UserEntitiy;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    //データベースに保存
    @Transactional
    public void DateInput(UserRequest userRequest) {
        userRepository.save(createUser(userRequest));
    }

    //データベースのクラスに値をセットする
    public UserEntitiy createUser(UserRequest userRequest) {
        Date now = new Date();
        //パスワードのハッシュ化を行う
        String encode = passwordEncoder.encode(userRequest.getPassword());
        UserEntitiy user = new UserEntitiy();
        user.setUserId(userRequest.getUserid());
        user.setEmail(userRequest.getEmail());
        user.setPassword(encode);
        user.setCreatedAt(now);

        return user;
    }

    //ユーザーIDを検索する
    public Optional<UserEntitiy> searchId(String userid) {
        return userRepository.findByUserId(userid);
    }
}