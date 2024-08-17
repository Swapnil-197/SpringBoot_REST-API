package com.in.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.in.entity.Student;

@Service
public interface StudentService {

	public String saveOrUpdate(Student student);
	public Student getById(Integer sid);
	public List<Student> getAll();
	public String deleteById(Integer sid);
}
