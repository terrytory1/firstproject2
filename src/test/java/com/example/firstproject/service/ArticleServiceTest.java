package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링부트와 연동되어 테스트
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {

        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c)); // 예상

        List<Article> articles = articleService.index(); // 실제

        assertEquals(expected.toString(), articles.toString()); // 비교

    }

    @Test
    void show_suc() {
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111"); // 예상

        Article article = articleService.show(id); //실제

        assertEquals(expected.toString(), article.toString()); // 비교
    }

    @Test
    void show_fail() {
        Long id = -1L;
        Article expected = null; // 예상

        Article article = articleService.show(id); //실제

        assertEquals(expected, article); // 비교
    }

    @Test
    @Transactional
    void create_suc() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        Article article = articleService.create(dto); //실제

        assertEquals(expected.toString(), article.toString()); // 비교

    }

    @Test
    @Transactional
    void create_fail_id_포함() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        Article article = articleService.create(dto); //실제

        assertEquals(expected, article); // 비교

    }
}