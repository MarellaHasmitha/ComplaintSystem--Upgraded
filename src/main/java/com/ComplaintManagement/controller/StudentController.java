package com.ComplaintManagement.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ComplaintManagement.Service.StudentService;
import com.ComplaintManagement.dto.StudentDTO;
import com.ComplaintManagement.model.Student;
import com.ComplaintManagement.repository.StudentRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
@Validated
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public StudentDTO createStudent(@Valid @RequestBody StudentDTO studentDTO)
	{
		    Student student=studentService.convertToStudent(studentDTO);
	        Student savedStudent=studentRepo.save(student);
	        return studentService.convertTOStudentDTO(savedStudent);
		
	}
	
	@GetMapping
	public List<StudentDTO>getAllStudents(){
		return studentRepo.findAll().stream().map(student ->studentService.convertTOStudentDTO(student)).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public StudentDTO  getStudentById(@PathVariable Long id)
	{
		Student student= studentRepo.findById(id).orElseThrow(()
				-> new RuntimeException("Student not Found"));
		return studentService.convertTOStudentDTO(student);
	}
	
	
}
