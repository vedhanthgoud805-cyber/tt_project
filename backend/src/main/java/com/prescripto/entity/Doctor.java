package com.prescripto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prescripto.util.JsonConverters;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String image;

    @Column(nullable = false)
    private String speciality;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private String experience;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String about;

    @Column(nullable = false)
    private Boolean available = true;

    @Column(nullable = false)
    private Double fees = 0.0;

    @Convert(converter = JsonConverters.AddressConverter.class)
    @Column(columnDefinition = "TEXT", nullable = false)
    private Map<String, String> address = new HashMap<>();

    @Column(name = "created_date", nullable = false)
    private Long date = System.currentTimeMillis();

    @JsonProperty("slots_booked")
    @Convert(converter = JsonConverters.SlotsBookedConverter.class)
    @Column(name = "slots_booked", columnDefinition = "TEXT")
    private Map<String, List<String>> slotsBooked = new HashMap<>();

    public Doctor() {
        if (this.address == null) {
            this.address = new HashMap<>();
            this.address.put("line1", "");
            this.address.put("line2", "");
        }
        if (this.slotsBooked == null) {
            this.slotsBooked = new HashMap<>();
        }
    }

    @JsonProperty("_id")
    public String getMongoId() {
        return id != null ? String.valueOf(id) : null;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Boolean getAvailable() {
        return available != null ? available : true;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Double getFees() {
        return fees != null ? fees : 0.0;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Map<String, String> getAddress() {
        if (address == null) {
            address = new HashMap<>();
            address.put("line1", "");
            address.put("line2", "");
        }
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Map<String, List<String>> getSlotsBooked() {
        if (slotsBooked == null) {
            slotsBooked = new HashMap<>();
        }
        return slotsBooked;
    }

    public void setSlotsBooked(Map<String, List<String>> slotsBooked) {
        this.slotsBooked = slotsBooked;
    }
}
