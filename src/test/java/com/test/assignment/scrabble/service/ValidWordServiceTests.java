package com.test.assignment.scrabble.service;

import com.test.assignment.scrabble.to.ResultResponseTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidWordServiceTests {

    @Autowired
    private ValidWordService validWordService;

    @Test
    void saveValidWordOK() {
        ResultResponseTO response = validWordService.saveValidWord("dumpling");
        assert validWordService.listAll().stream().anyMatch(w -> w.getWord().equals("dumpling"));
        assert response.getMessage().equals("Word dumpling listed as valid.") ||
                response.getMessage().equals("This word is already listed as valid.");
    }

    @Test
    void saveValidWordExists() {
        ResultResponseTO response = validWordService.saveValidWord("beaver");
        assert !response.isAccepted();
        assert response.getMessage().equals("This word is already listed as valid.");
    }

    @Test
    void saveValidWordExistsCaseInsensitive() {
        ResultResponseTO response = validWordService.saveValidWord("beaVER");
        assert !response.isAccepted();
        assert response.getMessage().equals("This word is already listed as valid.");
    }

    @Test
    void saveValidWordContainsIllegalLetters() {
        ResultResponseTO response = validWordService.saveValidWord("ämblik123");
        assert !response.isAccepted();
        assert response.getPoints().equals(-10);
        assert response.getMessage().equals("Contains invalid letters: [1, 2, 3, ä].");
        assert response.getWord().equals("ämblik123");
    }

}
