package com.example.hostelmanagement.dto;

public class RoomDTO {
    private Integer roomId;
    private String roomNumber;
    private Integer capacity;
    private Integer occupied;

    public RoomDTO() {}

    public RoomDTO(Integer roomId, String roomNumber, Integer capacity, Integer occupied) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.occupied = occupied;
    }

    public Integer getRoomId() { return roomId; }
    public void setRoomId(Integer roomId) { this.roomId = roomId; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public Integer getOccupied() { return occupied; }
    public void setOccupied(Integer occupied) { this.occupied = occupied; }
}
