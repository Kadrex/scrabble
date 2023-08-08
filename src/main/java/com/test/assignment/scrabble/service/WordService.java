package com.test.assignment.scrabble.service;

import com.test.assignment.scrabble.model.ValidWord;
import com.test.assignment.scrabble.repository.PointsRepository;
import com.test.assignment.scrabble.repository.ValidWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    @Autowired
    private PointsRepository pointsRepository;

    @Autowired
    private ValidWordsRepository validWordsRepository;

    public String saveValidWord(String word) {
        // Check if already exists
        if (validWordsRepository.existsByWord(word)) {
            return "exists";
        }
        ValidWord validWordEntity = new ValidWord();
        validWordEntity.setWord(word);
        validWordsRepository.save(validWordEntity);
        return "grapes";
    }
}
