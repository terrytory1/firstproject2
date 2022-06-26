package com.example.firstproject.repository;

import com.example.firstproject.entity.Rank;
import com.example.firstproject.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankRepository extends JpaRepository<Rank, Long> {

    public List<Record> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name",
                        Member.class)
                .setParameter("name", name)
                .getResultList();

}
