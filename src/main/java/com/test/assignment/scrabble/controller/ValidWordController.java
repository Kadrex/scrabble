package com.test.assignment.scrabble.controller;

import com.test.assignment.scrabble.model.ValidWord;
import com.test.assignment.scrabble.service.ValidWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ValidWordController {

    @Autowired
    private ValidWordService validWordService;

    @GetMapping(value = "listValidWords")
    public ResponseEntity<List<ValidWord>> listValid() {
        return ResponseEntity.ok(validWordService.listAll());
    }

    @PostMapping(value = "saveValidWord")
    public ResponseEntity<String> saveValidWord(@RequestParam(value = "word") String word) {
        return ResponseEntity.ok(validWordService.saveValidWord(word));
    }

}
