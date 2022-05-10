package com.example.crudjpa.demo.repositories;

import com.example.crudjpa.demo.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
