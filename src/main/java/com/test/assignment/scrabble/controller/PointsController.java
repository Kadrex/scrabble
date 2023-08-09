package com.test.assignment.scrabble.controller;

import com.test.assignment.scrabble.service.PointsService;
import com.test.assignment.scrabble.to.PointsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("api/points")
@RestController
@CrossOrigin(origins = "${frontend.url}")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @GetMapping(path = "/guide")
    public ResponseEntity<List<PointsTO>> getPoints() {
        return ResponseEntity.ok(pointsService.getPoints());
    }

}
