package com.andersen.project.controller;

import com.andersen.project.dto.StudentsDto;
import com.andersen.project.entity.Students;
import com.andersen.project.exception.ValidationException;
import com.andersen.project.service.StudentsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@Log
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping("/save")
    public StudentsDto saveStudent(@RequestBody StudentsDto studentsDto) throws
            ValidationException {
        log.info("Handling save - " + studentsDto);
        return studentsService.saveStudents(studentsDto);
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
