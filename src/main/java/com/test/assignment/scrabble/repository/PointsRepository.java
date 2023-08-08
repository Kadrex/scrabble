package com.test.assignment.scrabble.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.assignment.scrabble.model.Points;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointsRepository extends JpaRepository<Points, Long> {

    List<Points> findAll();
}
