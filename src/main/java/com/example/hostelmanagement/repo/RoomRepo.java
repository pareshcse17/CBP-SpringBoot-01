package com.example.hostelmanagement.repo;

import com.example.hostelmanagement.dto.RoomDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepo {
    private final List<RoomDTO> rooms = new ArrayList<>();

    public List<RoomDTO> findAll() {
        return new ArrayList<>(rooms);
    }

    public void save(RoomDTO room) {
        rooms.add(room);
    }

    public void delete(RoomDTO room) {
        rooms.remove(room);
    }
}
