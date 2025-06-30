package com.example.hostelmanagement.repo;

import com.example.hostelmanagement.dto.MaintenanceRequestDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MaintenanceRequestRepo {
    private final List<MaintenanceRequestDTO> requests = new ArrayList<>();

    public List<MaintenanceRequestDTO> findAll() {
        return new ArrayList<>(requests);
    }

    public void save(MaintenanceRequestDTO request) {
        requests.add(request);
    }

    public void delete(MaintenanceRequestDTO request) {
        requests.remove(request);
    }
}
