package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id // 대표값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id") // 대표값
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {
        // 예외 발생
        if (dto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패 id가 없어야 합니다");
        if (dto.getArticleId() != article.getId())
            throw new IllegalArgumentException("댓글 생성 실패 id가 잘못되었습니다.");

        return new Comment (
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        if (this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정 실패 id가 잘못되었습니다");

        if (dto.getNickname() != null)
            this.nickname = dto.getNickname();

        if (dto.getBody() != null)
            this.body = dto.getBody();
    }
}
