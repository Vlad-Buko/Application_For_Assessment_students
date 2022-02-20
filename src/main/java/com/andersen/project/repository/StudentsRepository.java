package com.andersen.project.repository;

import com.andersen.project.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
    Students findByLastName(String lastName);
}
