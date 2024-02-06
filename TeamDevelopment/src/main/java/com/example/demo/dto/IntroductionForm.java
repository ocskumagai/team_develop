package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IntroductionForm {
    @NotEmpty(message = "名前を入力してください")
    @Size(max = 10, message = "名前は10文字以下で入力してください")
    private String name;

    @NotEmpty(message = "フリガナを入力してください")
    @Size(max = 20, message = "フリガナは20文字以内で入力してください")
    private String kana;

    private String gender;

    @NotEmpty(message = "趣味は必須項目です。1つ以上選んでください")
    private String[] hobbies;

    private String word;
}


