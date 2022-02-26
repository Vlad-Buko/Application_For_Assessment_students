package com.andersen.project.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameTeam;
}
