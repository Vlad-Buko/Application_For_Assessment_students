package com.andersen.project.controller;

import com.andersen.project.dto.StudentsDto;
import com.andersen.project.dto.TeamDto;
import com.andersen.project.entity.Students;
import com.andersen.project.exception.ValidationException;
import com.andersen.project.service.StudentsService;
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

@RequestMapping("/students")
@AllArgsConstructor
@RestController
@Log
public class StudentsController {

    private final StudentsService studentsService;
    private final TeamService teamService;

    @PostMapping("/save")
    public void saveStudent(@RequestBody StudentsDto studentsDto
//                            @RequestBody TeamDto teamDto
                         ) throws
            ValidationException {
//        System.out.println(teamDto.getId());
        log.info("Handling save - " + studentsDto);
        studentsService.saveStudents(studentsDto);
    }

    @GetMapping("/findAll")
    public List<StudentsDto> findAllStudents() {
        log.info("Handling find *** ");
        return studentsService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudents(@PathVariable Integer id)
    {
        log.info("Handling delete - " + id);
        studentsService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }



}
