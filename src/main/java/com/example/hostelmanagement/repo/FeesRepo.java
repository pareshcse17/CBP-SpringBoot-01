package com.example.hostelmanagement.repo;

import com.example.hostelmanagement.entity.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeesRepo extends JpaRepository<Fees, Integer> {
    List<Fees> findByStudentId(Integer studentId);
    List<Fees> findByIsPaidAndAmount(Boolean isPaid, Double amount);
}
