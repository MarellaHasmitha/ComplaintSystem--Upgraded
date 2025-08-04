package com.ComplaintManagement.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintDTO {
	
	private Long id;
	@NotBlank(message="Subject is required")
	private String subject;
	
	@NotBlank(message="Description is required")
	private String description;
	
	@NotBlank(message="status is mandatory field")
	private String status;
	
	@NotBlank(message="Priority should be mention")
	private String priority;
	private LocalDateTime createdAt;
	
	private Long studentId;
	private String studentName;

}
