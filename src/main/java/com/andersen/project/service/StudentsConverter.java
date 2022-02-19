package com.andersen.project.service;

import com.andersen.project.dto.StudentsDto;
import com.andersen.project.entity.Students;
import org.springframework.stereotype.Component;

@Component
public class StudentsConverter {
    public Students fromStudentDtoToUse(StudentsDto studentsDto) {
        Students students = new Students();
        students.setId(studentsDto.getId());
        students.setName(studentsDto.getName());
        students.setLastName(students.getLastName());
        return students;
    }

    public StudentsDto fromStudentToStudentDto(Students students) {
        return StudentsDto.builder()
                .id(students.getId())
                .lastName(students.getLastName())
                .name(students.getName())
                .build();
    }
}
