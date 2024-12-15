package com.example.studentManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentManagement.entity.student;
import com.example.studentManagement.repository.repository;

@Service
public class service {
	
	@Autowired
	private repository rs;

	
   public List<student> getall(){
	   return rs.findAll();
	   } 
	   
  

public student savestudent(student ss2 ) {
	return rs.save(ss2);
}



public void deletebyallid( Long id) {
	rs.deleteById(id);
}



public student getStudentById(Long id) {
	// TODO Auto-generated method stub
	return rs.findById(id).get();
}



public student updateStudent(student S) {
	return rs.save(S);
	
}




}
