package com.test.assignment.scrabble.service;

import com.test.assignment.scrabble.model.ValidWord;
import com.test.assignment.scrabble.repository.LetterGroupRepository;
import com.test.assignment.scrabble.repository.ValidWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class ValidWordService {

    @Autowired
    private ValidWordsRepository validWordsRepository;

    @Autowired
    private LetterGroupRepository letterGroupRepository;

    public String saveValidWord(String word) {
        if (validWordsRepository.existsByWord(word)) {
            return "exists";
        }
        List<String> invalidLetters = getInvalidLetters(word);
        if (invalidLetters.size() > 0) {
            String message = invalidLetters.size() == 1 ? "letter" : "letters";
            return "Contains invalid " + message + ": " + String.join(", ", invalidLetters);
        }
        ValidWord validWordEntity = new ValidWord();
        validWordEntity.setWord(word);
        validWordsRepository.save(validWordEntity);
        return "grapes";
    }

    private List<String> getInvalidLetters(String word) {
        List<String> invalidLetters = new ArrayList<>();
        List<String> validLetters = letterGroupRepository.findAllLetters();
        for (String letter : new HashSet<>(Arrays.asList(word.split("")))) {
            if (!validLetters.contains(letter.toUpperCase())) {
                invalidLetters.add(letter);
            }
        }
        return invalidLetters;
    }

    public List<ValidWord> listAll() {
        return validWordsRepository.findAllByOrderByWord();
    }

}
