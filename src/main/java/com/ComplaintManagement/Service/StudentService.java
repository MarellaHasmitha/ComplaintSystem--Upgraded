package com.ComplaintManagement.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ComplaintManagement.dto.ComplaintDTO;
import com.ComplaintManagement.dto.StudentDTO;
import com.ComplaintManagement.model.Student;

@Service
public class StudentService {
	
	@Autowired
     private final ComplaintService  complaintService;
     
     public StudentService(ComplaintService complaintService) {
    	 this.complaintService =complaintService;
     }
     
     public  StudentDTO  convertTOStudentDTO(Student student) {
    	StudentDTO dto=new StudentDTO();
    	
    	dto.setId(student.getId());
    	dto.setName(student.getName());
    	dto.setEmail(student.getEmail());
    	
    	List<ComplaintDTO> complaintDTOs=student.getComplaints().stream().map(complaint -> complaintService.convertToComplaintDTO(complaint)).collect(Collectors.toList());
    	
    	dto.setComplaints(complaintDTOs);
    	return dto;
     }
     
     public Student convertToStudent(StudentDTO dto) {
    	 Student student=new Student();
    	 student.setName(dto.getName());
    	 student.setEmail(dto.getEmail());
    	 return student;
     }
	
}