package com.example.hostelmanagement.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "warden")
public class Warden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wardenId;

    private String name;
    private String phone;
    private Integer hostelId;

    // @OneToMany(mappedBy = "warden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinColumn(name = "hostel_id")
    // List<Hostel> hostels;

    // Getters and setters
    public Integer getWardenId() { return wardenId; }
    public void setWardenId(Integer wardenId) { this.wardenId = wardenId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getHostelId() { return hostelId; }
    public void setHostelId(Integer hostelId) { this.hostelId = hostelId; }
}
