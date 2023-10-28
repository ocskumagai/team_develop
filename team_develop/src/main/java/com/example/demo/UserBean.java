package com.example.demo;

import jakarta.validation.constraints.NotBlank;

public class UserBean {
	
	@NotBlank
	private String id;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
}
