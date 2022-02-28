package com.andersen.project.controller;

import com.andersen.project.dto.TeamDto;
import com.andersen.project.exception.ValidationException;
import com.andersen.project.service.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

@RestController
@RequestMapping("/teams")
@Log
@AllArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/save")
    public TeamDto saveTeam(@RequestBody TeamDto teamDto) throws ValidationException {
        log.info("Handling save team " + teamDto);
        return teamService.saveTeam(teamDto);
    }

    @GetMapping("/allTeam")
    public List<TeamDto> findAllTeam() {
        log.info("Handling find all team --");
        return teamService.findAll();
    }
}
