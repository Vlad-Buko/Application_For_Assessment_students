package com.andersen.project.controller;

import com.andersen.project.dto.TeamDto;
import com.andersen.project.exception.ValidationException;
import com.andersen.project.service.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

@RequestMapping("/teams")
@Log
@RestController
@AllArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/save")
    public TeamDto saveTeam(@RequestBody TeamDto teamDto) throws
            ValidationException {
        log.info("Handling save team " + teamDto);
        return teamService.saveTeam(teamDto);
    }

    @GetMapping("/teamAll")
    public List<TeamDto> findAllTeam() {
        log.info("Handling find team ");
        return teamService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudents(@PathVariable Integer id)
    {
        log.info("Handling delete team " + id);
        teamService.deleteTeam(id);
        return ResponseEntity.ok().build();
    }

}
