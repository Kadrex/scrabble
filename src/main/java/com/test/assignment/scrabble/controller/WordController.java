package com.test.assignment.scrabble.controller;

import com.test.assignment.scrabble.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WordController {

    @Autowired
    private WordService wordService;

    @PostMapping(value = "saveValidWord")
    public ResponseEntity<String> saveValidWord(@RequestParam(value = "word") String word) {
        return ResponseEntity.ok(wordService.saveValidWord(word));
    }
}
