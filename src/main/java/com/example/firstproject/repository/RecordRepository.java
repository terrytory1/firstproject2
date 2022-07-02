package com.example.firstproject.repository;

import com.example.firstproject.dto.RecordDTO;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.entity.Rank;
import com.example.firstproject.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query(value =
            "SELECT new com.example.firstproject.dto.RecordDTO(d.name, COUNT(d.game), SUM(d.win), SUM(d.lose), SUM(d.win)/COUNT(d.game), SUM(d.kill), SUM(d.death), SUM(d.assist), (SUM(d.kill)+SUM(d.assist))/SUM(d.death))" +
                    "FROM Record d" +
                    "GROUP BY d.name")
    List<RecordDTO> findByName(); // 통계쿼리

}
