package com.test.assignment.scrabble.controller;

import com.test.assignment.scrabble.model.ValidWord;
import com.test.assignment.scrabble.service.ValidWordService;
import com.test.assignment.scrabble.to.ResultResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/validWords")
@RestController
@CrossOrigin(origins = "${frontend.url}")
public class ValidWordController {

    @Autowired
    private ValidWordService validWordService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<ValidWord>> listValid() {
        return ResponseEntity.ok(validWordService.listAll());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResultResponseTO> saveValidWord(@RequestParam(value = "word") String word) {
        return ResponseEntity.ok(validWordService.saveValidWord(word));
    }

}
