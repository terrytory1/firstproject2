package com.example.firstproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity // 해당 클래스로 테이블을 만듬
@AllArgsConstructor // 생성자 추가
@NoArgsConstructor // 디폴트 생성자 추가
@ToString
@Getter @Setter
public class Record {

    @Id // 대표값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rank_id")
    private Rank rank;
    @Column
    private String name;
    @Column
    private Long game;
    @Column
    private String champion;
    @Column
    private Long kill;
    @Column
    private Long death;
    @Column
    private Long assist;
    @Column
    private Long win;
    @Column
    private Long lose;
    @Column
    private Long season;
}