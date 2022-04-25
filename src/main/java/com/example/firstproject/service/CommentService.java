package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        //반환
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }
    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패 게시글이 없습니다")); //게시글 조회

        Comment comment = Comment.createComment(dto, article); // 댓글 엔티티 생성

        Comment created = commentRepository.save(comment); // 댓글 엔티티를 db로 저장

        return CommentDto.createCommentDto(created); // 댓글 엔티티를 dto로 변환및 반환
    }
    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        //댓글 조회
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패 댓글이 없습니다"));
        //댓글 수정
        target.patch(dto);

        Comment updated = commentRepository.save(target);

        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        //댓글 조회
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패 댓글이 없습니다"));

        commentRepository.delete(target);

        return CommentDto.createCommentDto(target);
    }
}