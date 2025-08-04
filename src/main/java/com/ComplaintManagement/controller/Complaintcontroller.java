package com.ComplaintManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ComplaintManagement.Service.ComplaintService;
import com.ComplaintManagement.dto.ComplaintDTO;
import com.ComplaintManagement.model.Complaint;
import com.ComplaintManagement.model.ComplaintStatus;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin
@Validated
public class Complaintcontroller {

	@Autowired
	private ComplaintService service;
	
	
	@GetMapping
	public List<ComplaintDTO> getAllComplaints(){
		return service.getAllComplaintDTO();
	}
	
	@GetMapping("/{id}")
	public ComplaintDTO getById(@PathVariable Long id) {
		return service.getComplaintById(id);
	}
	
	
	
	@GetMapping("/priority/{level}")
	public List<ComplaintDTO> getByPriority(@PathVariable String level)
	{
		return service.getByPriority(level);
	}
	
	@PutMapping("/{id}/status")
	public ComplaintDTO updateStatus(@PathVariable Long id,@RequestParam ComplaintStatus status) {
		return service.updateComplaintStatus(id,status);
	}
	
	@PostMapping("/students/{studentId}")
	public ComplaintDTO addComplaintToStudent(@PathVariable Long studentId,@Valid @RequestBody ComplaintDTO complaintDTO) {
		return  service.addComplaintForStudent(studentId,complaintDTO);
	}
	
}
