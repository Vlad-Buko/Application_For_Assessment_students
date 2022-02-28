package com.andersen.project.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "team")
@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nameTeam;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Students> students;

}
