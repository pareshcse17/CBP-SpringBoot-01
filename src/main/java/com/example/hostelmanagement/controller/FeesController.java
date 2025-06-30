package com.example.hostelmanagement.controller;

import com.example.hostelmanagement.dto.FeesDTO;
import com.example.hostelmanagement.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
public class FeesController {
    @Autowired
    private FeesService feesService;

    @Value("${public.api.security.key}")
    private String publicApiSecurityKey;

    @GetMapping
    public ResponseEntity<List<FeesDTO>> getAllFees() {
        List<FeesDTO> feesList = feesService.getAllFees();
        return ResponseEntity.ok(feesList);
    }

    @PostMapping
    public ResponseEntity<Void> addFees(@RequestBody FeesDTO fees) {
        feesService.addFees(fees);
        return ResponseEntity.ok().build();
    }
}
