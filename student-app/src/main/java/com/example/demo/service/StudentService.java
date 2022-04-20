package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	public List<Student> getAllStudent();
	public Student createStudent(Student student);
	public void deleteStudent(int id);
	public Student getStudent(int id);
}
