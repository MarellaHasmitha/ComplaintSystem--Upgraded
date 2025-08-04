package com.ComplaintManagement.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    
	private Long id;
	@NotBlank(message="Name is required")
	private String name;
	
	@Email(message="Email must be valid")
	@NotBlank(message="Email is required")
	private String email;
	
	private List<ComplaintDTO> complaints;
}
