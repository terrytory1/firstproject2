package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // jpa와 연동한 테스트
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회") // 보여질 이름
    void findByArticleId() {
        // 4번 게시글의 댓글
        {
            Long articleId = 4L;

            List<Comment> comments = commentRepository.findByArticleId(articleId);

            Article article = new Article(4L, "인생 영화", "ㄱ");
            Comment a = new Comment(1L, article, "park", "베테랑");
            Comment b = new Comment(2L, article, "kim", "변호사");
            Comment c = new Comment(3L, article, "lee", "어게인");
            List<Comment> expected = Arrays.asList(a,b,c);

            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글");
        }


        {
            Long articleId = 1L;

            List<Comment> comments = commentRepository.findByArticleId(articleId);

            Article article = new Article(1L, "가가가가", "1111");
            List<Comment> expected = Arrays.asList();

            assertEquals(expected.toString(), comments.toString(), "1번 글의 모든 댓글");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        {
            String nickname = "park";

            List<Comment> comments = commentRepository.findByNickname(nickname);

            Comment a = new Comment(1L, new Article(4L, "인생 영화", "ㄱ"), nickname, "베테랑");
            Comment b = new Comment(4L, new Article(5L, "소울 푸드", "ㄱㄱ"), nickname, "치킨");
            Comment c = new Comment(7L, new Article(6L, "취미", "ㄱㄱㄱ"), nickname, "조깅");
            List<Comment> expected = Arrays.asList(a,b,c);

            assertEquals(expected.toString(), comments.toString(), "park의 모든 댓글");
        }
    }
}