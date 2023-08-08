package com.test.assignment.scrabble.repository;

import com.test.assignment.scrabble.model.ValidWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidWordsRepository extends JpaRepository<ValidWord, Long> {

    List<ValidWord> findAll();

    boolean existsByWord(String word);

}
