package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    //データベースに保存
    @Transactional
    public void DataInput(UserRequest userRequest) {
        userRepository.save(createUser(userRequest));
    }

    //データベースのクラスに値をセットする
    public UserEntity createUser(UserRequest userRequest) {
        Date now = new Date();
        //パスワードのハッシュ化を行う
        String encode = passwordEncoder.encode(userRequest.getPassword());
        UserEntity user = new UserEntity();
        user.setUserId(userRequest.getUserid());
        user.setEmail(userRequest.getEmail());
        //ハッシュ化されたパスワードをデータベースに保存
        user.setPassword(encode);
        user.setCreatedAt(now);

        return user;
    }

    //ユーザーIDを検索する
    public UserEntity searchId(String userid) {
        return userRepository.findByUserId(userid);
    }
}