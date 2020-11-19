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
		char grade = calculateGrade(percentage);
		student.setGrade(grade);
		student.setPerc(percentage);
	}
	
	public char calculateGrade(float percentage) {
		if(percentage<=100 && percentage>=85)
			return 'A';
		else if (percentage<85 && percentage>=70)
			return 'B';
		else if (percentage<70 && percentage>=50)
			return 'C';
		else if (percentage<50 && percentage>=35)
			return 'D';
		else 
			return 'F';
	}
	
	public String deleteStudent(long rollNo) {
		repo.deleteById(rollNo);
		return "Student removed!!";
	}
}
