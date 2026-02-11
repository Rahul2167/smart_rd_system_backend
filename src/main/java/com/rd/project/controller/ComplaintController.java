package com.rd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rd.project.entity.Complaint;
import com.rd.project.repo.ComplaintRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    // GET: Get all complaints (Admin only)
    @GetMapping("/comp")
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAllByOrderByDateDesc();
    }

    // GET: Get complaints by user phone
    @GetMapping("/comp/{phone}")
    public List<Complaint> getUserComplaints(@PathVariable String phone) {
        return complaintRepository.findByUserPhoneOrderByDateDesc(phone);
    }

    // POST: Submit new complaint (User only)
    @PostMapping("/savecomplaint")
    public ResponseEntity<?> submitComplaint(@RequestBody Complaint complaint) {
        try {
            // Log the received data to debug
            System.out.println("Received complaint: " + complaint);
            System.out.println("User Phone: " + complaint.getUserPhone());
            System.out.println("User Name: " + complaint.getUserName());

            // Set current date if not set
            if (complaint.getDate() == null) {
                complaint.setDate(java.time.LocalDate.now());
            }

            // Set default status if not set
            if (complaint.getStatus() == null) {
                complaint.setStatus("pending");
            }

            Complaint savedComplaint = complaintRepository.save(complaint);
            return ResponseEntity.ok(savedComplaint);
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return ResponseEntity.badRequest().body("Error submitting complaint: " + e.getMessage());
        }
    }

    // PUT: Update complaint status (Admin only)
    @PutMapping("/updtcomp")
    public ResponseEntity<?> updateComplaint(@RequestBody Complaint complaint) {
        try {
            Optional<Complaint> existingComplaint = complaintRepository.findById(complaint.getId());
            if (existingComplaint.isPresent()) {
                Complaint updatedComplaint = existingComplaint.get();
                updatedComplaint.setStatus(complaint.getStatus());
                updatedComplaint.setAdminResponse(complaint.getAdminResponse());

                // Set resolved date if status is "resolved" or "closed"
                if (("resolved".equalsIgnoreCase(complaint.getStatus()) ||
                        "closed".equalsIgnoreCase(complaint.getStatus())) &&
                        complaint.getResolvedDate() == null) {
                    updatedComplaint.setResolvedDate(java.time.LocalDate.now());
                } else {
                    updatedComplaint.setResolvedDate(complaint.getResolvedDate());
                }

                complaintRepository.save(updatedComplaint);
                return ResponseEntity.ok(updatedComplaint);
            }
            return ResponseEntity.badRequest().body("Complaint not found");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating complaint: " + e.getMessage());
        }
    }

    // DELETE: Delete complaint (Admin only) - FIXED
    @DeleteMapping("/dltcomp/{id}")
    public ResponseEntity<?> deleteComplaint(@PathVariable("id") Long id) { // Added explicit path variable name
        try {
            if (complaintRepository.existsById(id)) {
                complaintRepository.deleteById(id);
                return ResponseEntity.ok("Complaint deleted successfully");
            }
            return ResponseEntity.badRequest().body("Complaint not found");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting complaint: " + e.getMessage());
        }
    }
}