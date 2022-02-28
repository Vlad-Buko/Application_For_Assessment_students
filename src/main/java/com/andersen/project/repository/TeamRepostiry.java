package com.andersen.project.repository;

import com.andersen.project.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author Vladislav Domaniewski 24_99 (c)
 * For company Andersen
 */

public interface TeamRepostiry extends JpaRepository <Team, Integer> {
}
