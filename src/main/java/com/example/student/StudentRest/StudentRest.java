package com.example.student.StudentRest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.createExcel.excelGenerator;
import com.example.student.dao.StudentRepository;
import com.example.student.model.Student;

@RestController
public class StudentRest {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public StudentRest(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@GetMapping("/downloadExcel/student.xlsx")
	public ResponseEntity<InputStreamResource> excelStudentReport() throws IOException{
		List<Student> students = (List<Student>)studentRepo.findAll();
		
		ByteArrayInputStream in = excelGenerator.studentToExcel(students);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","attachment; filename=Student.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
		
	}
}
