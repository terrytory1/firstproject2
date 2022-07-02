package com.example.firstproject.repository;

import com.example.firstproject.dto.RecordDTO;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface NumberRepository extends JpaRepository<Number, Long> {
}
