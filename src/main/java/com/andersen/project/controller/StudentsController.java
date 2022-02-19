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
@CrossOrigin
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping("/save")
    public StudentsDto saveStudents(@RequestBody StudentsDto studentsDto) throws ValidationException {
        log.info("Hanling save students: " + studentsDto);
        return studentsService.saveStudent(studentsDto);
    }

    @GetMapping("/findAll")
    public List<StudentsDto> findAllStudents() {
        log.info("Handling find all students request");
        return studentsService.findAll();
    }

    @GetMapping("/findByLogin")
    public StudentsDto findByLastName(@RequestParam String lastName){
        log.info("Handling find by last name request: " + lastName);
        return studentsService.findByName(lastName);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudents(@PathVariable Integer id) {
        log.info("Handling delete student" + id);
        studentsService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}
