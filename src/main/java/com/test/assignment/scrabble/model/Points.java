package com.test.assignment.scrabble.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "points")
public class Points {

    @Id
    private Long id;

    @Column
    private Long letterGroupId;

    @Column
    private Integer points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLetterGroupId() {
        return letterGroupId;
    }

    public void setLetterGroupId(Long letterGroupId) {
        this.letterGroupId = letterGroupId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
