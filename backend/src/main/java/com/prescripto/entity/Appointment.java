package com.prescripto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prescripto.util.JsonConverters;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String docId;

    @Column(nullable = false)
    private String slotDate;

    @Column(nullable = false)
    private String slotTime;

    @Convert(converter = JsonConverters.MapConverter.class)
    @Column(columnDefinition = "LONGTEXT")
    private Map<String, Object> userData = new HashMap<>();

    @Convert(converter = JsonConverters.MapConverter.class)
    @Column(columnDefinition = "LONGTEXT")
    private Map<String, Object> docData = new HashMap<>();

    @Column(nullable = false)
    private Double amount = 0.0;

    @Column(name = "created_date", nullable = false)
    private Long date = System.currentTimeMillis();

    @Column(nullable = false)
    private Boolean cancelled = false;

    @Column(nullable = false)
    private Boolean payment = false;

    @Column(nullable = false)
    private Boolean isCompleted = false;

    public Appointment() {}

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(String slotDate) {
        this.slotDate = slotDate;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public Map<String, Object> getUserData() {
        return userData != null ? userData : new HashMap<>();
    }

    public void setUserData(Map<String, Object> userData) {
        this.userData = userData;
    }

    public Map<String, Object> getDocData() {
        return docData != null ? docData : new HashMap<>();
    }

    public void setDocData(Map<String, Object> docData) {
        this.docData = docData;
    }

    public Double getAmount() {
        return amount != null ? amount : 0.0;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Boolean getCancelled() {
        return cancelled != null ? cancelled : false;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Boolean getPayment() {
        return payment != null ? payment : false;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    public Boolean getIsCompleted() {
        return isCompleted != null ? isCompleted : false;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
