package com.test.assignment.scrabble.model;

import jakarta.persistence.*;

@Table(name = "letter_group")
public class LetterGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long groupId;

    @Column
    private String letter;
}
