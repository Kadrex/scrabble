package com.test.assignment.scrabble.model;

import jakarta.persistence.*;

@Entity
@Table(name = "letter_group")
public class LetterGroup {

    @Id
    private Long id;

    @Column(name = "group_id")
    private Long groupId;

    @Column
    private String letter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "LetterGroup{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", letter='" + letter + '\'' +
                "}\n";
    }

}
