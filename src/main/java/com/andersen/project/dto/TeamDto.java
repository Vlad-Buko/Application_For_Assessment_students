package com.andersen.project.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamDto {
    private Integer id;
    private String name;
}
