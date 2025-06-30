package com.example.hostelmanagement.dto;

import java.time.LocalDate;

public class MaintenanceRequestDTO {
    private Integer requestId;
    private Integer studentId;
    private String description;
    private String status;
    private LocalDate requestDate;

    public MaintenanceRequestDTO() {}

    public MaintenanceRequestDTO(Integer requestId, Integer studentId, String description, String status, LocalDate requestDate) {
        this.requestId = requestId;
        this.studentId = studentId;
        this.description = description;
        this.status = status;
        this.requestDate = requestDate;
    }

    public Integer getRequestId() { return requestId; }
    public void setRequestId(Integer requestId) { this.requestId = requestId; }
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
}
