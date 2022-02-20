package com.andersen.project.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "table_name")
@NoArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last")
    private String lastName;

    @Column(name = "score")
    private String score;
}
