package com.example.demo.repository;

import com.example.demo.model.UserEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntitiy, String> {
    //一致するユーザーIDの情報を取得する
    Optional<UserEntitiy> findByUserId(String userid);
}