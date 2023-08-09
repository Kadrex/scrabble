package com.test.assignment.scrabble.service;

import com.test.assignment.scrabble.to.PointsTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PointsServiceTests {

    @Autowired
    private PointsService pointsService;

    @Test
    void getPoints() {
        List<PointsTO> pointsList = pointsService.getPoints();
        List<PointsTO> expectedList = new ArrayList<>();
        expectedList.add(createPointsTO(1, Arrays.asList("A", "E", "I", "L", "N", "O", "R", "S", "T", "U")));
        expectedList.add(createPointsTO(2, Arrays.asList("D", "G")));
        expectedList.add(createPointsTO(3, Arrays.asList("B", "C", "M", "P")));
        expectedList.add(createPointsTO(4, Arrays.asList("F", "H", "V", "W", "Y")));
        expectedList.add(createPointsTO(5, List.of("K")));
        expectedList.add(createPointsTO(8, Arrays.asList("J", "X")));
        expectedList.add(createPointsTO(10, Arrays.asList("Q", "Z")));
        assert pointsList.containsAll(expectedList);
    }

    private PointsTO createPointsTO(Integer points, List<String> letters) {
        PointsTO pointsTO = new PointsTO();
        pointsTO.setPoints(points);
        pointsTO.setLetters(letters);
        return pointsTO;
    }

}
