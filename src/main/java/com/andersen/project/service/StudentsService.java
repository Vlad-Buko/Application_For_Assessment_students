package com.andersen.project.service;

import com.andersen.project.dto.StudentsDto;
import com.andersen.project.exception.ValidationException;

import java.util.List;

public interface StudentsService {
    StudentsDto saveStudent(StudentsDto studentsDto) throws ValidationException;

    void deleteStudent(Integer studentId);

    StudentsDto findByName(String lastName);

    List<StudentsDto> findAll();
}
