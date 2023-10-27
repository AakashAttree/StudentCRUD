package com.CarSchool.Student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarSchool.Student.model.StudentInfo;
import com.CarSchool.Student.repositry.StudentRepo;

@RestController
@RequestMapping("/api")

public class StudentController {
	
	private static final String UI = "http://localhost:4200";
	@Autowired
	StudentRepo studentRepo;
	@CrossOrigin(origins = UI)
	@PostMapping("/Student")
	public String createStudentInfo(@RequestBody StudentInfo studentInfo) {
		studentRepo.save(studentInfo);
		return "student info created";
		
		
	}
	@CrossOrigin(origins = UI)
	@GetMapping("/getStudent")
	public ResponseEntity<List<StudentInfo>> GetAllStudent() {
		List<StudentInfo> studentList = new ArrayList<>();
		studentRepo.findAll().forEach(studentList::add);
		return new ResponseEntity<List<StudentInfo>>(studentList , HttpStatus.OK);
		
	}
	@CrossOrigin(origins = UI)
	@GetMapping("/Student/{id}")
	public ResponseEntity<StudentInfo> GetStudentById(@PathVariable Long id){
		 Optional<StudentInfo> stdInfo = studentRepo.findById(id);
		 if(stdInfo.isPresent()) {
			 return  new ResponseEntity<StudentInfo>(stdInfo.get(), HttpStatus.FOUND);
		 }else {
			 return new ResponseEntity<StudentInfo>(HttpStatus.NOT_FOUND);
		 }
	}
	@CrossOrigin(origins = UI)
	@PutMapping("/student/{id}")
	public String UpdateStudentInfo(@PathVariable Long id , @RequestBody StudentInfo studentInfo) {
		Optional<StudentInfo> stdInfo = studentRepo.findById(id);
		
		if (stdInfo.isPresent()) {
			StudentInfo existStudent = stdInfo.get();
			existStudent.setAddress(studentInfo.getAddress());
			existStudent.setAmount(studentInfo.getAmount());
			existStudent.setDl(studentInfo.getDl());
			existStudent.setEmail(studentInfo.getEmail());
			existStudent.setGender(studentInfo.getGender());
			existStudent.setName(studentInfo.getName());
			existStudent.setNumber(studentInfo.getNumber());
			existStudent.setPhoto(studentInfo.getPhoto());
			existStudent.setResult(studentInfo.getResult());
			existStudent.setStatus(studentInfo.getStatus());
			existStudent.setZipCode(studentInfo.getZipCode());
			
			studentRepo.save(existStudent);
			return "details save";
			
		}else {
			return "student not found against id = " + id;
		}
	}
	@CrossOrigin(origins = UI)
	@DeleteMapping("/Student/{id}")
	public String DeleteStudentById(@PathVariable Long id ) {
		studentRepo.deleteById(id);
		return "Student Deleted";
	}
	@CrossOrigin(origins = UI)
	@DeleteMapping("/Student")
	public String DeleteAllStudent() {
		studentRepo.deleteAll();
		return "All Student deleted";
	}
	
}
