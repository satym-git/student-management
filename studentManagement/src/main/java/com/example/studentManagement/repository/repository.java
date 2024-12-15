package com.example.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.studentManagement.entity.student;

public interface repository extends JpaRepository<student,Long> {
	

}
