package com.test.assignment.scrabble.controller;

import com.test.assignment.scrabble.service.PointsService;
import com.test.assignment.scrabble.to.PointsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PointsController {

    @Autowired
    private PointsService pointsService;


    @GetMapping(value = "pointsGuide")
    public ResponseEntity<List<PointsTO>> getPoints() {
        return ResponseEntity.ok(pointsService.getPoints());
    }
}
