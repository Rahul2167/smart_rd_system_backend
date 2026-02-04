package com.rd.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rd.project.entity.Admin;

public interface Adminrepo extends JpaRepository<Admin, Integer> {
    Admin findByPhone(String phone);
    boolean existsByPhone(String phone);
    Admin findByPhoneAndPassword(String phone, String password);
}