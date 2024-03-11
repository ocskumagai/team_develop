package com.example.demo.repository;

import com.example.demo.model.IntroductionEntity;
import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroductionRepository extends JpaRepository<IntroductionEntity,Integer> {
    //ユーザーIDを検索する処理
    IntroductionEntity findByUserId(String userId);
}
