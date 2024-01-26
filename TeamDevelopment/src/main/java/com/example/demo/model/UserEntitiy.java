package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class UserEntitiy {
    //	ユーザーIDを登録するカラム
    @Id
    @Column(name = "user_id")
    private String userId;
    //	メールアドレスを登録するカラム
    @Column(name = "email")
    private String email;
    //	パスワードを保存するカラム
    @Column(name = "password")
    private String password;
    //	日付を登録するカラム
    @Column(name = "created_at")
    private Date createdAt;
}
