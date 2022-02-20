package com.andersen.project.service;

import com.andersen.project.dto.StudentsDto;
import com.andersen.project.entity.Students;
import com.andersen.project.exception.ValidationException;
import com.andersen.project.repository.StudentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultStudentsService implements StudentsService {
    private final StudentsRepository studentsRepository;
    private final StudentsConverter studentsConverter;

    @Override
    public StudentsDto saveStudents(StudentsDto studentsDto) throws ValidationException {
        validateStudentsDto(studentsDto);
        Students savedStudent =
                studentsRepository.save(studentsConverter.fromStudentsDtoToStudents(studentsDto));
        return studentsConverter.fromStudentsToStudentsDto(savedStudent);
    }

    private void validateStudentsDto(StudentsDto studentsDto) throws ValidationException {
        if (isNull(studentsDto)) {
            throw new ValidationException("Object student is null");
        }
        if (isNull(studentsDto.getLastName()) || studentsDto.getLastName().isEmpty()) {
            throw new ValidationException("Last name is empty");
        }
    }

    @Override
    public void deleteStudent(Integer studentsId) {
        studentsRepository.deleteById(studentsId);
    }

    @Override
    public StudentsDto findByLastName(String lastName) {
        Students students = studentsRepository.findByLastName(lastName);
        if (students != null) {
            return studentsConverter.fromStudentsToStudentsDto(students);
        }
        return null;
    }

    @Override
    public List<StudentsDto> findAll() {
        return studentsRepository.findAll()
                .stream()
                .map(studentsConverter::fromStudentsToStudentsDto)
                .collect(Collectors.toList());
    }
}
