package com.test.assignment.scrabble.service;

import com.test.assignment.scrabble.model.ValidWord;
import com.test.assignment.scrabble.repository.LetterGroupRepository;
import com.test.assignment.scrabble.repository.ValidWordsRepository;
import com.test.assignment.scrabble.to.ResultResponseTO;
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

    public ResultResponseTO saveValidWord(String word) {
        if (validWordsRepository.existsByWord(word)) {
            return responseOfError(word, "This word is already listed as valid.");
        }
        List<String> invalidLetters = getInvalidLetters(word);
        if (invalidLetters.size() > 0) {
            String message = invalidLetters.size() == 1 ? "letter" : "letters";
            return responseOfError(word, "Contains invalid " + message + ": " + String.join(", ", invalidLetters + "."));
        }
        ValidWord validWordEntity = new ValidWord();
        validWordEntity.setWord(word);
        validWordsRepository.save(validWordEntity);
        return responseOfSuccess(word, "Word " + word + " listed as valid.");
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

    private ResultResponseTO responseOfError(String word, String message) {
        ResultResponseTO response = new ResultResponseTO();
        response.setWord(word);
        response.setPoints(-10);
        response.setMessage(message);
        response.setAccepted(false);
        return response;
    }

    private ResultResponseTO responseOfSuccess(String word, String message) {
        ResultResponseTO response = new ResultResponseTO();
        response.setWord(word);
        response.setMessage(message);
        response.setAccepted(true);
        return response;
    }

}
