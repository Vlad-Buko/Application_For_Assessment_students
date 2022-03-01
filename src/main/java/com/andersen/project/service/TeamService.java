package com.andersen.project.service;

import com.andersen.project.dto.TeamDto;

import java.util.List;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

public interface TeamService {
    TeamDto saveTeam(TeamDto teamDto) ;

    List<TeamDto> findAll();
}
