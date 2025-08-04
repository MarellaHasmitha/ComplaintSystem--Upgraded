package com.ComplaintManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ComplaintManagement.dto.ComplaintDTO;
import com.ComplaintManagement.model.Complaint;
import com.ComplaintManagement.model.ComplaintStatus;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	
	List<ComplaintDTO>findByStatus(ComplaintStatus status);
	List<Complaint> findByPriority(String priority);

}
