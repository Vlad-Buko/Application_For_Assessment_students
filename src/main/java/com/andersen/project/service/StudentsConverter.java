package com.andersen.project.service;

import com.andersen.project.dto.StudentsDto;
import com.andersen.project.entity.Students;
import org.springframework.stereotype.Component;

@Component
public class StudentsConverter {
    public Students fromStudentsDtoToStudents(StudentsDto studentsDto) {
        Students students = new Students();
        students.setId(studentsDto.getId());
        students.setName(studentsDto.getName());
        students.setLastName(studentsDto.getLastName());
        students.setScore(studentsDto.getScore());
        return students;
    }

    public StudentsDto fromStudentsToStudentsDto(Students students) {
        return StudentsDto.builder()
                .id(students.getId())
                .name(students.getName())
                .lastName(students.getLastName())
                .score(students.getScore())
                .build();
    }
}
