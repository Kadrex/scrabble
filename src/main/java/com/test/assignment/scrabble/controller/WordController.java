package com.test.assignment.scrabble.controller;

import com.test.assignment.scrabble.service.ValidWordService;
import com.test.assignment.scrabble.service.ScrabbleService;
import com.test.assignment.scrabble.to.ResultResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WordController {

    @Autowired
    private ScrabbleService scrabbleService;

    @Autowired
    private ValidWordService validWordService;

    @GetMapping(value = "submit")
    public ResponseEntity<ResultResponseTO> submitWord(@RequestParam String word) {
        return ResponseEntity.ok(scrabbleService.submitWord(word));
    }

    @PostMapping(value = "saveValidWord")
    public ResponseEntity<String> saveValidWord(@RequestParam(value = "word") String word) {
        return ResponseEntity.ok(validWordService.saveValidWord(word));
    }
}
