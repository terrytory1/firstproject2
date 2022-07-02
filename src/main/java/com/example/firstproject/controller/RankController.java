package com.example.firstproject.controller;

import com.example.firstproject.dto.RecordDTO;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Number;
import com.example.firstproject.entity.Rank;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.NumberRepository;
import com.example.firstproject.repository.RankRepository;
import com.example.firstproject.repository.RecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class RankController {

    @Autowired
    private RecordRepository RecordRepository;

    @Autowired
    private NumberRepository NumberRepository;

    @GetMapping("/rank")
    public String newRankForm(Model model) {
        List<RecordDTO> rankEntityList = RecordRepository.findByName();; // 데이터 가져오기

        model.addAttribute("rankList", rankEntityList); // 가져온 데이터를 뷰로 전달

            return "article/rank";
    }
}
