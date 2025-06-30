package com.example.hostelmanagement.repo;

import com.example.hostelmanagement.dto.WardenDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WardenRepo {
    private final List<WardenDTO> wardens = new ArrayList<>();

    public List<WardenDTO> findAll() {
        return new ArrayList<>(wardens);
    }

    public void save(WardenDTO warden) {
        wardens.add(warden);
    }

    public void delete(WardenDTO warden) {
        wardens.remove(warden);
    }
}
