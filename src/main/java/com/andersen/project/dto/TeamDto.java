package com.andersen.project.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;


/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

@Data
@Builder
public class TeamDto {
    private Integer id;
    private String nameTeam;
    private List<StudentsDto> studentsDto;
}
