package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "introductions")
public class IntroductionEntity {
    //管理番号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "introduction_id")
    private int introductionId;
    //ユーザーID
    @Column(name = "user_id")
    private String userId;
    //名前
    @Column(name = "name")
    private String name;
    //フリガナ
    @Column(name = "kana")
    private String kana;
    //性別
    @Column(name = "gender")
    private String gender;
    //趣味
    @Column(name = "hobby")
    private String[] hobbies;
    //一言
    @Column(name = "word")
    private String word;
    //登録日
    @Column(name = "created_at")
    private Date createdAt;
    //更新日
    @Column(name = "updated_at")
    private Date updatedAt;
}
