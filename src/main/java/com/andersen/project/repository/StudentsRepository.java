package com.andersen.project.repository;

import com.andersen.project.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

public interface StudentsRepository extends JpaRepository<Students, Integer> {
}
