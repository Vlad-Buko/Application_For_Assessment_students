package com.andersen.project.service;

import com.andersen.project.entity.Students;
import com.andersen.project.exception.ValidationException;
import com.andersen.project.dto.StudentsDto;
import com.andersen.project.repository.StudentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultStudentsService implements StudentsService {

    private StudentsRepository studentsRepository;
    private StudentsConverter studentsConverter;
    @Override
    public StudentsDto saveStudent(StudentsDto studentsDto) throws ValidationException {
        validateStudentsDto(studentsDto);
        Students savedStudent = studentsRepository.save(studentsConverter.fromStudentDtoToUse(studentsDto));
        return studentsConverter.fromStudentToStudentDto(savedStudent);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentsRepository.deleteById(studentId);
    }

    @Override
    public StudentsDto findByName(String lastName) {
        return studentsConverter.fromStudentToStudentDto(studentsRepository.findStudentsBy(lastName));
    }

    @Override
    public List<StudentsDto> findAll() {
        return studentsRepository.findAll()
                .stream()
                .map(studentsConverter::fromStudentToStudentDto)
                .collect(Collectors.toList());
    }

    private void validateStudentsDto (StudentsDto studentsDto) throws ValidationException {
        if (isNull(studentsDto)) {
            throw new ValidationException("Object student is null");
        }
        if (isNull(studentsDto.getLastName()) || studentsDto.getLastName().isEmpty()) {
            throw new ValidationException("Last name is empty");
        }
    }
}
