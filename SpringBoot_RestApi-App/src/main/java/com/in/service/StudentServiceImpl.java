package com.in.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.in.entity.Student;
import com.in.exception.ResourceNotFoundException;
import com.in.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repository;
	
	@Override
	public String saveOrUpdate(Student student) {
		repository.save(student);
		return "Success";
	}

	@Override
	public Student getById(Integer sid) {
		Optional<Student> byId = repository.findById(sid);
		if(byId.isPresent()) {
			return byId.get();
		}else {
			throw new ResourceNotFoundException("Student is not Present with ID" + sid);
		}
	}

	@Override
	public List<Student> getAll() {
		return repository.findAll();
	}

	@Override
	public String deleteById(Integer sid) {
		Optional<Student> byId = repository.findById(sid);
		if(byId.isPresent()) {
			repository.deleteById(sid);
			return "Record has deleted";
		}else {
			return "Record has not found";
		}
	}
}
