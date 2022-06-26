package com.example.firstproject.repository;

import com.example.firstproject.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Number, Long> {
}
