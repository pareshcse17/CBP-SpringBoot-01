package com.example.hostelmanagement.service;

import com.example.hostelmanagement.dto.FeesDTO;
import com.example.hostelmanagement.entity.Fees;
import com.example.hostelmanagement.repo.FeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeesService {
    @Autowired
    private FeesRepo feesRepo;

    public List<FeesDTO> getAllFees() {
        List<Fees> feesList = feesRepo.findAll();
        List<FeesDTO> dtoList = new java.util.ArrayList<>();
        for (Fees fees : feesList) {
            dtoList.add(mapToDTO(fees));
        }
        return dtoList;
    }

    public void addFees(FeesDTO feesDTO) {
        Fees fees = mapToEntity(feesDTO);
        feesRepo.save(fees);
    }

    private FeesDTO mapToDTO(Fees fees) {
        FeesDTO dto = new FeesDTO();
        dto.setFeesId(fees.getFeesId());
        dto.setStudentId(fees.getStudentId());
        dto.setAmount(fees.getAmount());
        dto.setDueDate(fees.getDueDate());
        dto.setIsPaid(fees.getIsPaid());
        return dto;
    }

    private Fees mapToEntity(FeesDTO dto) {
        Fees fees = new Fees();
        fees.setFeesId(dto.getFeesId());
        fees.setStudentId(dto.getStudentId());
        fees.setAmount(dto.getAmount());
        fees.setDueDate(dto.getDueDate());
        fees.setIsPaid(dto.getIsPaid());
        return fees;
    }
}
