package com.andersen.project.converter;

import com.andersen.project.dto.TeamDto;
import com.andersen.project.entity.Team;
import org.springframework.stereotype.Component;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

@Component
public class TeamConverter {
    public Team fromTeamDtoToTeam(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setNameTeam(teamDto.getNameTeam());
        team.setStudents(teamDto.getStudentsTeam());
        return team;
    }

    public TeamDto fromTeamToTeamDto(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .nameTeam(team.getNameTeam())
                .studentsTeam(team.getStudents())
                .build();
    }
}
