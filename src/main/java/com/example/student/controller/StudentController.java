package com.example.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteStudent/{rollNo}")
	public String deleteStudent(@PathVariable long rollNo) {
		return service.deleteStudent(rollNo);
	}
	
}
