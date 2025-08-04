package com.ComplaintManagement.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="student_id")
	@JsonIgnore
	private Student student;
	
	private String subject;
	
	@Column(length=1000)
	private String description;
	
	@Enumerated(EnumType.STRING)
	private ComplaintStatus status=ComplaintStatus.OPEN;
	
	private String priority;
	
	private LocalDateTime createdAt;
	
	@PrePersist
	public void prePersist() {
		createdAt=LocalDateTime.now();
	}
	

}
