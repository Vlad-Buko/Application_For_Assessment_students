package com.andersen.project.repository;

import com.andersen.project.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepostiroy extends JpaRepository <Team, Integer> {
}
