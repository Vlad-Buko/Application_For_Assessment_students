package com.andersen.project.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

@Table(name = "team")
@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_team")
    private String nameTeam;

    @OneToMany(mappedBy = "team" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Students> students;
}
