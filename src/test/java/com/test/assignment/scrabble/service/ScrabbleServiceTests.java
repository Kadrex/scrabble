package com.test.assignment.scrabble.service;

import com.test.assignment.scrabble.to.ResultResponseTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScrabbleServiceTests {

    @Autowired
    private ScrabbleService scrabbleService;

    @Test
    void submitWordOK() {
        ResultResponseTO response = scrabbleService.submitWord("beaver");
        String expectedExplanation = "beaver = 3+1+1+4+1+1 = 11";
        assert response.isAccepted();
        assert response.getPoints().equals(11);
        assert response.getMessage().equals(expectedExplanation);
        assert response.getWord().equals("beaver");
    }

    @Test
    void submitWordOKCaseInsensitive() {
        ResultResponseTO response = scrabbleService.submitWord("beAVer");
        String expectedExplanation = "beAVer = 3+1+1+4+1+1 = 11";
        assert response.isAccepted();
        assert response.getPoints().equals(11);
        assert response.getMessage().equals(expectedExplanation);
        assert response.getWord().equals("beAVer");
    }

    @Test
    void submitWordNotValid() {
        ResultResponseTO response = scrabbleService.submitWord("giraffe");
        String expectedMessage = "Not a valid word.";
        assert !response.isAccepted();
        assert response.getPoints().equals(-10);
        assert response.getMessage().equals(expectedMessage);
        assert response.getWord().equals("giraffe");
    }

}
