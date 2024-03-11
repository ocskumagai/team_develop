package com.example.demo.service;

import com.example.demo.dto.IntroductionForm;
import com.example.demo.model.IntroductionEntity;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.IntroductionRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class IntroductionService {

    @Autowired
    IntroductionRepository introductionRepository;

    //データベースのクラスに値をセットする
    public IntroductionEntity createIntroduction(IntroductionForm introductionForm) {
        final String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        Date now = new Date();
        IntroductionEntity introduction = new IntroductionEntity();
        introduction.setUserId(userId);
        introduction.setName(introductionForm.getName());
        introduction.setKana(introductionForm.getKana());
        introduction.setGender(introductionForm.getGender());
        introduction.setHobbies(introductionForm.getHobbies());
        introduction.setWord(introductionForm.getWord());
        introduction.setCreatedAt(now);

        return introduction;
    }
    //TODO:セーブアンドフラッシュ必要
    public void InputData(IntroductionForm introductionForm) {
        introductionRepository.save(createIntroduction(introductionForm));
    }

    public IntroductionEntity searchUserId (String userId){
        return introductionRepository.findByUserId(userId);
    }

    //重複チェック
    public IntroductionEntity doubleCheck(String userId) {
        return searchUserId(userId);
    }
}
