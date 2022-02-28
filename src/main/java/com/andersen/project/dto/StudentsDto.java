package com.andersen.project.dto;

import com.andersen.project.entity.Team;
import lombok.Builder;
import lombok.Data;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

@Data
@Builder
public class StudentsDto {
    private Integer id;
    private String name;
    private String lastName;
    private String score;
    private Team team;
}
