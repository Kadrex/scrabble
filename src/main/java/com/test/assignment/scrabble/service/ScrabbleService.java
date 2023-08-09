package com.test.assignment.scrabble.service;

import com.test.assignment.scrabble.repository.ValidWordsRepository;
import com.test.assignment.scrabble.to.PointsTO;
import com.test.assignment.scrabble.to.ResultResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScrabbleService {

    @Autowired
    private ValidWordsRepository validWordsRepository;

    @Autowired
    private PointsService pointsService;

    public ResultResponseTO submitWord(String word) {
        if (!validWordsRepository.existsByWord(word)) {
            return responseOfError(word);
        }
        return calculatePoints(word);
    }

    private ResultResponseTO calculatePoints(String word) {
        ResultResponseTO result = new ResultResponseTO();
        List<PointsTO> points = pointsService.getPoints();
        List<String> lettersInWord = new ArrayList<>(Arrays.asList(word.split("")));

        StringBuilder explanation = new StringBuilder(word + " = ");
        Integer pointsForWord = 0;
        for (int i = 0; i < lettersInWord.size(); i++) {
            if (i != 0) explanation.append("+");

            String letter = lettersInWord.get(i);
            Integer pointsForLetter = getPointsForLetter(points, letter.toUpperCase());
            pointsForWord += pointsForLetter;
            explanation.append(pointsForLetter);
        }
        explanation.append(" = ").append(pointsForWord);

        result.setExplanation(explanation.toString());
        result.setPoints(pointsForWord);
        result.setWord(word);
        result.setAccepted(true);

        return result;
    }

    private Integer getPointsForLetter(List<PointsTO> points, String letter) {
        return points.stream().filter(p -> p.getLetters().contains(letter)).findFirst().get().getPoints();
    }

    private ResultResponseTO responseOfError(String word) {
        ResultResponseTO response = new ResultResponseTO();
        response.setWord(word);
        response.setMessage("Not a valid word.");
        response.setAccepted(false);
        response.setPoints(-10);
        return response;
    }

}
