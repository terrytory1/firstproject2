package com.example.firstproject.service;

import com.example.firstproject.entity.Record;
import com.example.firstproject.repository.RankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RankService {

    public List<Record> findMembers() {
        return RankRepository.findAll();
    }
}
