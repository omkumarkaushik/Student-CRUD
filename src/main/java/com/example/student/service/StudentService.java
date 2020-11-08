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
		calculatePercentage(student);
		return repo.save(student);
	}
	
	public void calculatePercentage(Student student) {
		float sum = student.getLangMks()+student.getScienceMks()+student.getSstMks();
		float percentage = 100*sum/300;
		student.setPerc(percentage);
	}
	
	public String deleteStudent(long rollNo) {
		repo.deleteById(rollNo);
		return "Student removed!!";
	}
}
