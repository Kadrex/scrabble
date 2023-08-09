package com.test.assignment.scrabble.to;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointsTO pointsTO = (PointsTO) o;
        return Objects.equals(letters, pointsTO.letters) && Objects.equals(points, pointsTO.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letters, points);
    }

}
