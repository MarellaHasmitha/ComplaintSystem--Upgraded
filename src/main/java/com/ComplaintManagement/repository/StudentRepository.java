package com.ComplaintManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ComplaintManagement.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
