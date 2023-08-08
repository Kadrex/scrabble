package com.test.assignment.scrabble.service;

import com.test.assignment.scrabble.model.LetterGroup;
import com.test.assignment.scrabble.model.Points;
import com.test.assignment.scrabble.repository.LetterGroupRepository;
import com.test.assignment.scrabble.repository.PointsRepository;
import com.test.assignment.scrabble.repository.ValidWordsRepository;
import com.test.assignment.scrabble.to.PointsTO;
import com.test.assignment.scrabble.to.ResultResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScrabbleService {

    @Autowired
    private PointsRepository pointsRepository;

    @Autowired
    private ValidWordsRepository validWordsRepository;

    @Autowired
    private LetterGroupRepository letterGroupRepository;

    public ResultResponseTO submitWord(String word) {
        // Check if contains any non-ok letters
        if (!validWordsRepository.existsByWord(word)) {
            return responseOfError("Not a valid word.");
        }
        // Will never happen unless someone meddles with the database
        /*List<String> invalidLetters = getInvalidLetters(word);
        if (invalidLetters.size() > 0) {
            String message = invalidLetters.size() == 1 ? "letter" : "letters";
            return responseOfError("Contains invalid " + message + ": " + String.join(", ", invalidLetters));
        }*/
        return calculatePoints(word);
    }

    private ResultResponseTO calculatePoints(String word) {
        ResultResponseTO result = new ResultResponseTO();
        List<PointsTO> points = getPoints();
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

    private List<PointsTO> getPoints() {
        List<Points> pointsEntities = pointsRepository.findAll();
        List<LetterGroup> letterGroups = letterGroupRepository.findAll();
        List<PointsTO> points = new ArrayList<>();
        for (Points pointsEntity : pointsEntities) {
            PointsTO pointsTO = new PointsTO();
            pointsTO.setPoints(pointsEntity.getPoints());
            pointsTO.setLetters(letterGroups.stream().filter(lg -> Objects.equals(lg.getGroupId(), pointsEntity.getLetterGroupId())).map(LetterGroup::getLetter).toList());
            points.add(pointsTO);
        }
        return points;
    }

    private ResultResponseTO responseOfError(String message) {
        ResultResponseTO response = new ResultResponseTO();
        response.setMessage(message);
        response.setAccepted(false);
        return response;
    }
}
