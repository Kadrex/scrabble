package com.test.assignment.scrabble.model;

import jakarta.persistence.*;

@Entity
@Table(name = "group_id")
public class GroupId {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
