package com.example.hostelmanagement.repo;

import com.example.hostelmanagement.dto.StudentDTO;
import com.example.hostelmanagement.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByNameContainingIgnoreCase(String name);
    StudentDTO findByEmail(String email);
}
