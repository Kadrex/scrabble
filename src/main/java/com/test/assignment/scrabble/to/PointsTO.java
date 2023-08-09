package com.test.assignment.scrabble.to;

import java.util.List;

public class PointsTO {

    private List<String> letters;

    private Integer points;

    public List<String> getLetters() {
        return letters;
    }

    public void setLetters(List<String> letters) {
        this.letters = letters;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "PointsTO{" +
                "letters=" + letters +
                ", points=" + points +
                '}';
    }
}
