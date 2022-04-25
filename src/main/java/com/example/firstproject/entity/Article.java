package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity // 해당 클래스로 테이블을 만듬
@AllArgsConstructor // 생성자 추가
@NoArgsConstructor // 디폴트 생성자 추가
@ToString
@Getter
public class Article {

    @Id // 대표값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if(article.title != null)
            this.title = article.title;
        if(article.content != null)
            this.content = article.content;
    }
}
