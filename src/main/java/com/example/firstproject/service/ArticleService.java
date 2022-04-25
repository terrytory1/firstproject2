package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service //해당 클래스를 서비스로 인식하여 스프링부트에 객체를 생성
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if (article.getId() != null) {
            return null;
        }
        return  articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {

        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString()); // 수정용 엔티티 생성

        Article target = articleRepository.findById(id).orElse(null); //엔티티 조회

        if (target == null || id != article.getId()){ //잘못된 요청 처리
            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            return null;
        }

        target.patch(article);
        Article updated = articleRepository.save(target); // 정상 응답
        return updated;
    }

    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }
        articleRepository.delete(target);
        return target;
    }

    @Transactional // 해당 메서드를 트랙잭션으로 묶는다
    public List<Article> createArticles(List<ArticleForm> dtos) {
        List<Article> articleList = dtos.stream() //dto 묶음을 엔티티 묶음으로 변환
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        articleList.stream() // entitiy 묶음을 db로 저장장
               .forEach(article -> articleRepository.save(article));

        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결제 실패")
        );

        return articleList;
    }
}
