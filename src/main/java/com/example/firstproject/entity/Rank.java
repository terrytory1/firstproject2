package com.example.firstproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // 해당 클래스로 테이블을 만듬
@AllArgsConstructor // 생성자 추가
@NoArgsConstructor // 디폴트 생성자 추가
@ToString
@Getter @Setter
public class Rank {

    @Id // 대표값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    private Record record;
    @Column
    private String name;
    @Column
    private Long game;
    @Column
    private Long win;
    @Column
    private Long lose;
    @Column
    private Long winlate;
    @Column
    private Long kill;
    @Column
    private Long death;
    @Column
    private Long assist;
    @Column
    private Long kda;

}