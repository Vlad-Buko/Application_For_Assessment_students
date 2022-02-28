package com.andersen.project.service;

import com.andersen.project.dto.StudentsDto;
import com.andersen.project.exception.ValidationException;

import java.util.List;

public interface StudentsService {

    StudentsDto saveStudents(StudentsDto studentsDto) throws ValidationException;

    void deleteStudent(Integer studentsId);

    List<StudentsDto> findAll();
}
