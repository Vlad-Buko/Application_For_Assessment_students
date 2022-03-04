package com.andersen.project.service;

import com.andersen.project.dto.StudentsDto;
import com.andersen.project.entity.Students;
import com.andersen.project.exception.ValidationException;

import java.util.List;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

public interface StudentsService {

    StudentsDto saveStudents(StudentsDto studentsDto) throws ValidationException;

    void deleteStudent(Integer studentsId);

    List<StudentsDto> findAll();

    List<StudentsDto> addScore(Integer score);
}
