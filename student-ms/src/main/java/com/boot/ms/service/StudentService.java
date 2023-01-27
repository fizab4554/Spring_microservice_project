package com.boot.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.ms.entity.Student;
import com.boot.ms.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;

	public List<Student> getStudents() {
		return repository.findAll();

	}

	public Student getStudent(int stdId) {
		return repository.findById(stdId).orElse(null);
	}
	public void deleteStudentById(int stdId) {
		repository.deleteById(stdId);
	}

	public Student addStudent(Student student) {
		return repository.save(student);
	}

	public Student getUpdatedStudent(Student student) {
		Student studentData = repository.findById(student.getId()).get();
		studentData.setId(student.getId());
		studentData.setStdName(student.getStdName());
		studentData.setCourseId(student.getCourseId());
		
		return repository.save(studentData);
	}

}

	