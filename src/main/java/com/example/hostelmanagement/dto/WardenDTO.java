package com.example.hostelmanagement.dto;

public class WardenDTO {
    private Integer wardenId;
    private String name;
    private String phone;
    private Integer hostelId;

    public WardenDTO() {}

    public WardenDTO(Integer wardenId, String name, String phone, Integer hostelId) {
        this.wardenId = wardenId;
        this.name = name;
        this.phone = phone;
        this.hostelId = hostelId;
    }

    public Integer getWardenId() { return wardenId; }
    public void setWardenId(Integer wardenId) { this.wardenId = wardenId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getHostelId() { return hostelId; }
    public void setHostelId(Integer hostelId) { this.hostelId = hostelId; }
}
