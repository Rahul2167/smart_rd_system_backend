package com.rd.project.repo;

import com.rd.project.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findAllByOrderByDateDesc();
    List<Complaint> findByUserPhoneOrderByDateDesc(String userPhone);
}