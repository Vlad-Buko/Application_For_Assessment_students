package com.andersen.project.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentsDto {
    private Integer id;
    private String name;
    private String lastName;
    private String score;
}
