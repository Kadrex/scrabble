package com.test.assignment.scrabble.service;

import com.test.assignment.scrabble.model.LetterGroup;
import com.test.assignment.scrabble.model.Points;
import com.test.assignment.scrabble.repository.LetterGroupRepository;
import com.test.assignment.scrabble.repository.PointsRepository;
import com.test.assignment.scrabble.to.PointsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PointsService {

    @Autowired
    private PointsRepository pointsRepository;


    @Autowired
    private LetterGroupRepository letterGroupRepository;

    public List<PointsTO> getPoints() {
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
}
