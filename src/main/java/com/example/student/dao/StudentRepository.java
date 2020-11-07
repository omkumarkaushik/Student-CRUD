package com.example.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
