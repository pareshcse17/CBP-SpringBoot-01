package com.example.hostelmanagement.dto;

import java.time.LocalDate;

public class StudentDTO {
    private Integer studentId;
    private String name;
    private String email;
    private String phone;
    private Integer roomId;
    private LocalDate checkinDate;

    public StudentDTO() {}

    public StudentDTO(Integer studentId, String name, String email, String phone, Integer roomId, LocalDate checkinDate) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roomId = roomId;
        this.checkinDate = checkinDate;
    }

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getRoomId() { return roomId; }
    public void setRoomId(Integer roomId) { this.roomId = roomId; }
    public LocalDate getCheckinDate() { return checkinDate; }
    public void setCheckinDate(LocalDate checkinDate) { this.checkinDate = checkinDate; }
}
