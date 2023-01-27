package com.boot.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.ms.entity.Course;
import com.boot.ms.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository repository;

	public List<Course> getCourses() {
		return repository.findAll();

	}

	public Course getCourses(int courseId) {
		return repository.findById(courseId).orElse(null);
	}
	public Course getCourse(int courseId) {
		return repository.findById(courseId).orElse(null);
	}

	public void deleteCourseById(int courseId) {
		repository.deleteById(courseId);
	}

	public Course addCourse(Course course) {
		return repository.save(course);
	}

	public Course getUpdatedCourse(Course course) {
		Course courseData = repository.findById(course.getCourseId()).get();
		courseData.setCourseId(course.getCourseId());
		courseData.setCourseName(course.getCourseName());
		return repository.save(courseData);
	}

}

	
	



