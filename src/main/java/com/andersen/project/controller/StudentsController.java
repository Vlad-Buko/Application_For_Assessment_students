package com.andersen.project.controller;

import com.andersen.project.dto.StudentsDto;
import com.andersen.project.exception.ValidationException;
import com.andersen.project.service.StudentsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@Log
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping("/save")
    public StudentsDto saveStudent(@RequestBody StudentsDto studentsDto) throws
            ValidationException {
        log.info("Hanling one" + studentsDto);
        return studentsService.saveStudents(studentsDto);
    }

    @GetMapping("/findAll")
    public List<StudentsDto> findAllStudents() {
        log.info("Hanling two");
        return studentsService.findAll();
    }

    @GetMapping("/findByLogin")
    public StudentsDto findByLAstName(@RequestParam String lastName) {
        log.info("Hanling two" + lastName);
        return studentsService.findByLastName(lastName);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudents(@PathVariable Integer id)
    {
        log.info("Hanling tree" + id);
        studentsService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}
