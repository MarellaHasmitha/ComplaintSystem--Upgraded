package com.ComplaintManagement.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
   
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	@OneToMany(mappedBy = "student",cascade =CascadeType.ALL,orphanRemoval = true)
	
	private List<Complaint> complaints=new ArrayList<>();
	
}
 