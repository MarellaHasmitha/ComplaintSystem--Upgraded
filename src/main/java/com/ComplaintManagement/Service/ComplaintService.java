package com.ComplaintManagement.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ComplaintManagement.dto.ComplaintDTO;
import com.ComplaintManagement.model.Complaint;
import com.ComplaintManagement.model.ComplaintStatus;
import com.ComplaintManagement.model.Student;
import com.ComplaintManagement.repository.ComplaintRepository;
import com.ComplaintManagement.repository.StudentRepository;

import jakarta.validation.Valid;

@Service
public class ComplaintService {
	
	@Autowired
	private ComplaintRepository repo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	
	public ComplaintDTO convertToComplaintDTO(Complaint complaint)
	{
		ComplaintDTO dto=new ComplaintDTO();
		
		dto.setId(complaint.getId());
		dto.setSubject(complaint.getSubject());
		dto.setDescription(complaint.getDescription());
		dto.setStatus(complaint.getStatus().toString());
		dto.setPriority(complaint.getPriority());
		dto.setCreatedAt(complaint.getCreatedAt());
		
		if(complaint.getStudent()!=null) {
			dto.setStudentId(complaint.getStudent().getId());
			dto.setStudentName(complaint.getStudent().getName());
		}
		return dto;	
	}
	
	// Add Complaint for a student
		public ComplaintDTO addComplaintForStudent(Long studentId, ComplaintDTO complaintDTO)
		{
	         Student student=studentRepo.findById(studentId).orElseThrow(()->new RuntimeException("Student not Found"));
	         Complaint complaint=new Complaint();
	         
	        complaint.setId(complaintDTO.getId());
	 		complaint.setSubject(complaintDTO.getSubject());
	 		complaint.setDescription(complaintDTO.getDescription());
	 		complaint.setStatus(ComplaintStatus.valueOf(complaintDTO.getStatus().toUpperCase()));
	 		complaint.setPriority(complaintDTO.getPriority());
	 		complaint.setCreatedAt(complaintDTO.getCreatedAt());
	         
	 		complaint.setStudent(student);
	 		Complaint saved=repo.save(complaint);
	 		
	         return convertToComplaintDTO(saved);
		}
		
		
		// Get all complaints as DTOs
		public List<ComplaintDTO> getAllComplaintDTO()
		{
			return repo.findAll().stream().map(this::convertToComplaintDTO).collect(Collectors.toList());
		}
		
		
	
	 public ComplaintDTO updateComplaintStatus(Long id,ComplaintStatus status)
     {
     	Complaint complaint=repo.findById(id).orElseThrow(() -> new RuntimeException("Complaint not found"));
     	complaint.setStatus(status);
     	Complaint updated=repo.save(complaint);
     	return convertToComplaintDTO(updated);
     }
	
		public ComplaintDTO getComplaintById(Long id) {
			Complaint complaint=repo.findById(id).orElseThrow(() -> new RuntimeException("Complaint not Found"));
			return convertToComplaintDTO(complaint);
		}
		
		public List<ComplaintDTO> getByPriority(String priority)
		{
			List<Complaint> complaints =repo.findByPriority(priority.toUpperCase());
			List<ComplaintDTO> dtoList=new ArrayList<>();
			for(Complaint complaint:complaints) {
				dtoList.add(convertToComplaintDTO(complaint));
			}
			return dtoList;
		}
	
		}
