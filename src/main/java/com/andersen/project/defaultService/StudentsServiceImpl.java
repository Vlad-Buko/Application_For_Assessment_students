package com.andersen.project.defaultService;

import com.andersen.project.converter.StudentsConverter;
import com.andersen.project.dto.StudentsDto;
import com.andersen.project.entity.Students;
import com.andersen.project.entity.Team;
import com.andersen.project.exception.ValidationException;
import com.andersen.project.repository.StudentsRepository;
import com.andersen.project.repository.TeamRepostiry;
import com.andersen.project.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;


/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

@Service
@AllArgsConstructor
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;
    private final StudentsConverter studentsConverter;

    @Override
    public StudentsDto saveStudents(StudentsDto studentsDto) throws ValidationException {
        validateStudentsDto(studentsDto);
        Students savedStudent =
                studentsRepository.save(studentsConverter.fromStudentsDtoToStudents(studentsDto));
        return studentsConverter.fromStudentsToStudentsDto(savedStudent);
    }

    @Override
    public List<StudentsDto> addScore(Integer idStudent) {
        StudentsDto studentsDto;
        Students studentId = studentsRepository.getById(idStudent);
        studentId.setScore(+1);
        return studentsRepository.findAll()
                .stream()
                .map(studentsConverter::fromStudentsToStudentsDto)
                .collect(Collectors.toList());
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
    public List<StudentsDto> findAll() {
        return studentsRepository.findAll()
                .stream()
                .map(studentsConverter::fromStudentsToStudentsDto)
                .collect(Collectors.toList());
    }
}
