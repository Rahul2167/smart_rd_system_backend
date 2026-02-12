package com.rd.project.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rd.project.entity.Admin;
import com.rd.project.repo.Adminrepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")

public class Admincontrl {

    @Autowired
    private Adminrepo repo;

    @GetMapping("/admins")
    public java.util.List<Admin> findAllAdmins() {
        return repo.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin user) {
        try {
            // Check if phone already exists
            if (repo.existsByPhone(user.getPhone())) {
                return ResponseEntity.badRequest().body("Phone already registered");
            }

            // Set default role if not provided
            if (user.getRole() == null || user.getRole().isEmpty()) {
                user.setRole("USER");
            }

            // Generate Account Number (13 digits based on timestamp)
            if (user.getAccountNumber() == null || user.getAccountNumber().trim().isEmpty()) {
                String generatedAccount = String.valueOf(System.currentTimeMillis());
                user.setAccountNumber(generatedAccount);
                System.out.println("Generated Account Number for user " + user.getPhone() + ": " + generatedAccount);
            }

            // Save the user
            Admin savedUser = repo.save(user);

            // Return without password
            Map<String, Object> response = new HashMap<>();
            response.put("id", savedUser.getId());
            response.put("phone", savedUser.getPhone());
            response.put("name", savedUser.getName());
            response.put("role", savedUser.getRole());
            response.put("accountNumber", savedUser.getAccountNumber());
            response.put("isAdmin", "ADMIN".equals(savedUser.getRole()));
            response.put("message", "Registration successful");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }

    @PutMapping("/updtpassword")
    public Admin updateps(@Valid @RequestBody Admin p) {
        return repo.save(p);
    }

    @DeleteMapping("/dltadmin/{id}")
    public String DeleteBlg(@PathVariable("id") int id) {
        repo.deleteById(id);
        return "Record Delete Successfully......";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String phone = credentials.get("phone");
            String password = credentials.get("password");

            System.out.println("Login attempt: " + phone);

            // Special case: empty credentials for admin
            if ((phone == null || phone.isEmpty()) && (password == null || password.isEmpty())) {
                Map<String, Object> response = new HashMap<>();
                response.put("id", 0);
                response.put("phone", "admin");
                response.put("name", "Administrator");
                response.put("role", "ADMIN");
                response.put("isAdmin", true);
                response.put("message", "Admin login successful");
                return ResponseEntity.ok(response);
            }

            // Check if user exists
            Admin user = repo.findByPhoneAndPassword(phone, password);

            if (user == null) {
                return ResponseEntity.badRequest().body("Invalid phone number or password");
            }

            // Return user data
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("phone", user.getPhone());
            response.put("name", user.getName());
            response.put("accountNumber", user.getAccountNumber());
            response.put("role", user.getRole());
            response.put("isAdmin", "ADMIN".equals(user.getRole()));
            response.put("message", "Login successful");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Login failed: " + e.getMessage());
        }
    }
}
