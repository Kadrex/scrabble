package com.test.assignment.scrabble.controller;

import com.test.assignment.scrabble.model.ValidWord;
import com.test.assignment.scrabble.service.ValidWordService;
import com.test.assignment.scrabble.service.ScrabbleService;
import com.test.assignment.scrabble.to.PointsTO;
import com.test.assignment.scrabble.to.ResultResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WordController {

    @Autowired
    private ScrabbleService scrabbleService;

    @GetMapping(value = "submit")
    public ResponseEntity<ResultResponseTO> submitWord(@RequestParam String word) {
        return ResponseEntity.ok(scrabbleService.submitWord(word));
    }

}
