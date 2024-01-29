package com.example.demo.repository;

import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    //一致するユーザーIDの情報を取得する
   UserEntity findByUserId(String userid);
}