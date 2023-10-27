package com.Car.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Car.Student.model.StudentInfo;
import com.Car.Student.repositry.StudentRepository;



@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public StudentInfo registerStudent(StudentInfo student) {
		return studentRepository.save(student);
	}
	
	public List<StudentInfo> getStudents(){
		return (List<StudentInfo>) studentRepository.findAll();		 
	}
	
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}
	
	public StudentInfo updateStudent(StudentInfo student) {
		Integer id = student.getId();
		StudentInfo std = studentRepository.findById(id).get();
		std.setName(student.getName());
		std.setAddress(student.getAddress());
		std.setAmount(student.getAmount());
		std.setDl(student.getDl());
		std.setEmail(student.getEmail());
		std.setGender(student.getGender());
		std.setNumber(student.getNumber());
		std.setPhoto(student.getPhoto());
		std.setStatus(student.getStatus());
		std.setResult(student.getResult());
		std.setZipCode(student.getZipCode());
		return studentRepository.save(std);
	}
}
