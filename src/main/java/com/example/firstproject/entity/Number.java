package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 해당 클래스로 테이블을 만듬
@AllArgsConstructor // 생성자 추가
@NoArgsConstructor // 디폴트 생성자 추가
@ToString
@Getter
public class Number {

    @Id // 대표값 지정
    private Long gid;
}
