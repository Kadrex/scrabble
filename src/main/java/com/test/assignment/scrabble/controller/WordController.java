package com.test.assignment.scrabble.controller;

import com.test.assignment.scrabble.service.ScrabbleService;
import com.test.assignment.scrabble.to.ResultResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/scrabble")
@RestController
@CrossOrigin(origins = "${frontend.url}")
public class WordController {

    @Autowired
    private ScrabbleService scrabbleService;

    @GetMapping(path = "/submit")
    public ResponseEntity<ResultResponseTO> submitWord(@RequestParam String word) {
        return ResponseEntity.ok(scrabbleService.submitWord(word));
    }

}
