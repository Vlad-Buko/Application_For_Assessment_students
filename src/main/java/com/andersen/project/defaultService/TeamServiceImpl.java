package com.andersen.project.defaultService;

import com.andersen.project.converter.TeamConverter;
import com.andersen.project.dto.TeamDto;
import com.andersen.project.entity.Team;
import com.andersen.project.exception.ValidationException;
import com.andersen.project.repository.TeamRepostiry;
import com.andersen.project.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepostiry teamRepostiry;
    private final TeamConverter teamConverter;

    @Override
    public TeamDto saveTeam(TeamDto teamDto) throws ValidationException {
        validateTeamDto(teamDto);
        Team savedTeam =
                teamRepostiry.save(teamConverter.fromTeamDtoToTeam(teamDto));
        return teamConverter.fromTeamToTeamDto(savedTeam);
    }

    @Override
    public void deleteTeam(Integer idTeam) {

    }

    @Override
    public List<TeamDto> findAll() {
        return teamRepostiry.findAll()
                .stream()
                .map(teamConverter::fromTeamToTeamDto)
                .collect(Collectors.toList());
    }

    private void validateTeamDto(TeamDto teamDto) throws ValidationException {
        if (isNull(teamDto)) {
            throw new ValidationException("Object team is null");
        }
    }
}
