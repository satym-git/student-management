package com.example.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.studentManagement.entity.student;
import com.example.studentManagement.service.service;

@Controller
public class studentcontroller {
	
	
	
	@Autowired
	private service s;
	
	@Autowired
	private student ss;
	
	@GetMapping("/students")
	public String listStudent(Model m ) {
		m.addAttribute("students", s.getall());
		return "students";
		
	}
	@GetMapping("/students/new")
	public String createfor(Model model ) {
		model.addAttribute("ss", ss);
		return "create_student";
		
	}
	@PostMapping("/students")
	public String savestud(@ModelAttribute("ss") student ss) {
		s.savestudent(ss);
		return "redirect:/students";
		
	}
	@GetMapping("/students/{id}")
	public String deleteopt(@PathVariable Long  id) {
		s.deletebyallid(id);
		return "redirect:/students";
		
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String updatestud(@PathVariable Long id, Model m ) {
		m.addAttribute("student",s.getStudentById(id));
		return "edit_student";
		
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") student st,
			Model model) {
		
		// get student from database by id
		student existingStudent = s.getStudentById(id);

		existingStudent.setId(id);
		existingStudent.setFirstname(st.getFirstname());
		existingStudent.setLastname(st.getLastname());
		existingStudent.setEmail(st.getEmail());
		
		// save updated student object
		s.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	/*
	 * @GetMapping("/studentss")
	 * 
	 * @ResponseBody 
	 * public List<student> listStudent() {
	 *  return s.getall();
	 *   }
	 */

}
