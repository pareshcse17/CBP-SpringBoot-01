package com.example.hostelmanagement.repo;

import com.example.hostelmanagement.dto.HostelDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HostelRepo {
    private final List<HostelDTO> hostels = new ArrayList<>();

    public List<HostelDTO> findAll() {
        return new ArrayList<>(hostels);
    }

    public void save(HostelDTO hostel) {
        hostels.add(hostel);
    }

    public void delete(HostelDTO hostel) {
        hostels.remove(hostel);
    }
}
