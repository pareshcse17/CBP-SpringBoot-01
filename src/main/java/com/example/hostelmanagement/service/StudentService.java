package com.example.hostelmanagement.service;

import com.example.hostelmanagement.dto.StudentDTO;
import com.example.hostelmanagement.entity.Student;
import com.example.hostelmanagement.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        List<StudentDTO> dtoList = new java.util.ArrayList<>();
        for (Student student : students) {
            dtoList.add(mapToDTO(student));
        }
        return dtoList;
    }

    public void addStudent(StudentDTO studentDTO) {
        Student student = mapToEntity(studentDTO);
        studentRepo.save(student);
    }

    private StudentDTO mapToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setStudentId(student.getStudentId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setPhone(student.getPhone());
        dto.setRoomId(student.getRoomId());
        dto.setCheckinDate(student.getCheckinDate());
        return dto;
    }

    private Student mapToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setStudentId(dto.getStudentId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setRoomId(dto.getRoomId());
        student.setCheckinDate(dto.getCheckinDate());
        return student;
    }
}
