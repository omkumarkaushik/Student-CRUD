package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return service.getAllStudents();
	}
	
	@PostMapping("/addStudents")
	public List<Student> addStudent(@RequestBody List<Student> student){
		return service.addStudents(student);
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
}
