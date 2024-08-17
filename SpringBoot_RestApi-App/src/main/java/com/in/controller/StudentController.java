package com.in.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.entity.Student;
import com.in.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		String status = service.saveOrUpdate(student);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/Student/{sid}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer sid){
		Student student = service.getById(sid);
		return new ResponseEntity<>(student , HttpStatus.OK);
	}
	
	@GetMapping("Students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = service.getAll();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@PutMapping("/Update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student){
		String status = service.saveOrUpdate(student);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/DeleteStudent/{sid}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer sid){
		String status = service.deleteById(sid);
		return new ResponseEntity<>(status , HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> list = service.getAll();
		List<Student> student = list.stream()
		    .filter(s -> s.getAge() > 30)
		    .collect(Collectors.toList());
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
}
