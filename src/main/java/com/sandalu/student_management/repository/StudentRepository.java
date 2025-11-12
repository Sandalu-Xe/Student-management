package com.sandalu.student_management.repository;

import com.sandalu.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Spring Data JPA automatically provides all CRUD methods!
}