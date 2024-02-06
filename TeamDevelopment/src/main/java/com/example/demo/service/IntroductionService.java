package com.example.demo.service;

import com.example.demo.dto.IntroductionForm;
import com.example.demo.model.IntroductionEntity;
import com.example.demo.repository.IntroductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class IntroductionService {

    @Autowired
    IntroductionRepository introductionRepository;

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

    public void InputData(IntroductionForm introductionForm) {
        introductionRepository.save(createIntroduction(introductionForm));
    }
}