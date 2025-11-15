package com.sandalu.student_management.repository;

import com.sandalu.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContainingIgnoreCaseOrCourseContainingIgnoreCase(String nameQuery, String courseQuery);
    // Spring Data JPA automatically provides all CRUD methods!
}