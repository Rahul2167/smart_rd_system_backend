// Complaint.java
package com.rd.project.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "complaints")
public class Complaint {
	@Override
	public String toString() {
	    return "Complaint{" +
	            "id=" + id +
	            ", userId='" + userId + '\'' +
	            ", userName='" + userName + '\'' +
	            ", userPhone='" + userPhone + '\'' +
	            ", category='" + category + '\'' +
	            ", complaintText='" + complaintText + '\'' +
	            ", date=" + date +
	            ", status='" + status + '\'' +
	            ", adminResponse='" + adminResponse + '\'' +
	            ", resolvedDate=" + resolvedDate +
	            '}';
	}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String userId;
    private String userName;
    private String userPhone;
    private String category;
    
    @Column(length = 1000)
    private String complaintText;
    
    private LocalDate date;
    private String status; // pending, in-progress, resolved, closed
    private String adminResponse;
    private LocalDate resolvedDate;
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    
    public String getUserPhone() { return userPhone; }
    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getComplaintText() { return complaintText; }
    public void setComplaintText(String complaintText) { this.complaintText = complaintText; }
    
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getAdminResponse() { return adminResponse; }
    public void setAdminResponse(String adminResponse) { this.adminResponse = adminResponse; }
    
    public LocalDate getResolvedDate() { return resolvedDate; }
    public void setResolvedDate(LocalDate resolvedDate) { this.resolvedDate = resolvedDate; }
}