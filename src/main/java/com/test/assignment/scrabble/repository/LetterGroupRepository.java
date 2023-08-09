package com.test.assignment.scrabble.repository;

import com.test.assignment.scrabble.model.LetterGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterGroupRepository extends JpaRepository<LetterGroup, Long> {

    @Query(value = "select lg.letter from LetterGroup lg")
    List<String> findAllLetters();

}
