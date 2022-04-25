package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j // 로깅을 위함
public class ArticleController {

    @Autowired // 스프링 부트가 생성해놓은 객체에다 연결 (DI)
    private ArticleRepository articleRepository;

    @Autowired // 스프링 부트가 생성해놓은 객체에다 연결 (DI)
    private CommentService commentService;

    @GetMapping("/article/new")
    public String newArticleForm() {
        return "article/new";
    }

    @PostMapping("/article/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        //System.out.println(form.toString());

        Article article = form.toEntity(); // dto를 entitiy로 변환
        log.info(article.toString());

        Article saved = articleRepository.save(article); // 엔티티를 db로 저장
        log.info(saved.toString());

        return "redirect:/article/" + saved.getId();
    }

    @GetMapping("/article/{id}") //pathcariable는 url주소로부터 온다는 뜻
    public String show(@PathVariable Long id, Model model) {
        log.info ("id = " + id);

        Article articleEntity = articleRepository.findById(id).orElse(null); // id로 데이터를 가져옴
        List<CommentDto> commentDtos = commentService.comments(id);

        model.addAttribute("article", articleEntity); // 모델에 등록
        model.addAttribute("commentDtos", commentDtos);

        return "article/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        List<Article> articleEntityList = articleRepository.findAll(); // 모든 article 데이터 가져오기

        model.addAttribute("articleList", articleEntityList); // 가져온 데이터를 뷰로 전달

        return "article/index";
    }

    @GetMapping("/article/{id}/edit")
    public  String edit(@PathVariable Long id, Model model) {
        Article articleEntity = articleRepository.findById(id).orElse(null); // 수정할 데이터 가져오기

        model.addAttribute("article", articleEntity); // 모델에 데이터 등록

        return "article/edit";
    }

    @PostMapping("/article/update") //form이 패치 제공 안해서 임시
    public String update(ArticleForm form){
        log.info(form.toString());

        Article article = form.toEntity();
        log.info(article.toString());

        Article articleEntity = articleRepository.findById(article.getId()).orElse(null); // db에서 기존 데이터 가져옴
        if (articleEntity != null){
            articleRepository.save(article); // 엔티티가 db로 갱신
        }

        return "redirect:/article/" + article.getId();
    }

    @GetMapping("/article/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다");

        Article target = articleRepository.findById(id).orElse(null); // 삭제 대상을 가져온다
        log.info(target.toString());

        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다"); // 삭제알림판
        } // 삭제한다

        // 결과 페이지로 리다이렉트한다
        return "redirect/articles";
    }
}