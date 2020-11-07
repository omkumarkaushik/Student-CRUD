package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.dao.StudentRepository;
import com.example.student.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public List<Student> getAllStudents(){
		return repo.findAll();
	}
	
	public List<Student> addStudents(List<Student> student){
		return repo.saveAll(student);
	}
	
	public Student addStudent(Student student) {
		return repo.save(student);
	}
}
