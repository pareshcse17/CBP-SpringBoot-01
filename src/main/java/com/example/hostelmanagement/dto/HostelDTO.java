package com.example.hostelmanagement.dto;

public class HostelDTO {
    private Integer hostelId;
    private String name;
    private String location;

    public HostelDTO() {}

    public HostelDTO(Integer hostelId, String name, String location) {
        this.hostelId = hostelId;
        this.name = name;
        this.location = location;
    }

    public Integer getHostelId() { return hostelId; }
    public void setHostelId(Integer hostelId) { this.hostelId = hostelId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
