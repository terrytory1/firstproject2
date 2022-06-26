package com.example.firstproject.repository;

import com.example.firstproject.entity.Rank;
import com.example.firstproject.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findByName(String name);
}
