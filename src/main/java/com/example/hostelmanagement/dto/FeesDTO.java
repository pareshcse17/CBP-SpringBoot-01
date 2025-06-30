package com.example.hostelmanagement.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FeesDTO {
    private Integer feesId;
    private Integer studentId;
    private BigDecimal amount;
    private LocalDate dueDate;
    private Boolean isPaid;

    public FeesDTO() {}

    public FeesDTO(Integer feesId, Integer studentId, BigDecimal amount, LocalDate dueDate, Boolean isPaid) {
        this.feesId = feesId;
        this.studentId = studentId;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
    }

    public Integer getFeesId() { return feesId; }
    public void setFeesId(Integer feesId) { this.feesId = feesId; }
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public Boolean getIsPaid() { return isPaid; }
    public void setIsPaid(Boolean isPaid) { this.isPaid = isPaid; }
}
