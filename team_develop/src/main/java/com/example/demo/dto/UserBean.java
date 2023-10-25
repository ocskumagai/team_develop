package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/*ユーザー情報*/
public class UserBean {
	/* UserId */
	// 空白だった場合エラー
	@NotEmpty(message = "UserIdを入力してください")
	// 入力数字が20桁を入力した場合エラー
	@Size(max = 20, message = "IDは20桁以下にしてください")
	private String id;

	/* メールアドレス */
	@NotEmpty(message = "メールアドレスを入力してください")
	private String email;
	
	/* パスワード */
	@NotEmpty(message = "パスワードを入力してください")
	private String password;
}