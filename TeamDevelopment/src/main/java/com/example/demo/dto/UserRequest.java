package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {
    //ユーザーID
    //入力もが空だった場合エラーを格納
    @NotEmpty(message = "ユーザーIDは必須項目です")
    //入力文字が10文字以下
    @Size(max = 10, message = "ユーザーIDは10文字以下で入力してください")
    private String userid;
    //メールアドレス
    @Email(message = "メールアドレスは正しい形式で入力してください")
    @NotEmpty(message = "メールアドレスは必須項目です")
    private String email;
    //パスワード
    @NotEmpty(message = "パスワードは必須項目です")
    @Size(max = 10, message = "パスワードは10文字以下で入力してください")
    private String password;
    //日付
    private Date createdAt;
}
