package com.test.assignment.scrabble.model;

import jakarta.persistence.*;

@Table(name = "group_id")
public class GroupId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
