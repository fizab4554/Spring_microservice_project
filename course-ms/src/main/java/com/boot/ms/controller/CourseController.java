package com.boot.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boot.ms.entity.Course;
import com.boot.ms.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService service;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getall")
	public ResponseEntity<List<Course>> getCourses() {
		return new ResponseEntity<List<Course>>(service.getCourses(), HttpStatus.OK);
	}

	@GetMapping("/getcourse/{courseId}")
	public ResponseEntity<?> getCourse(@PathVariable int courseId) {
		Course course = service.getCourse(courseId);
		ResponseEntity<?> responseEntity = null;

		if (course == null) {
			responseEntity = new ResponseEntity<String>("No Bank present with given id  : " + courseId,
					HttpStatus.NOT_FOUND);

		} else {
			responseEntity = new ResponseEntity<Course>(course, HttpStatus.OK);
		}
		return responseEntity;

	}

	/*
	 * @DeleteMapping("/deletebank/{bank_id}") public void
	 * deleteById(@PathVariable("bank_id") int bank_id) {
	 * service.deleteBankById(bank_id); }
	 */
	/*
	 * @DeleteMapping("/deletebank") public ResponseEntity<List<Bank>>
	 * deleteBankById(int bank_id){ service.deleteBankById(bank_id); List<Bank> bank
	 * = new ArrayList<>(); service.getClass(); return new
	 * ResponseEntity<List<Bank>>(bank,HttpStatus.OK); }
	 */
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<String> deleteBankById(@PathVariable("courseId") int courseId) throws Exception {
		service.deleteCourseById(courseId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

	@PostMapping("/insert")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		return new ResponseEntity<Course>(service.addCourse(course), HttpStatus.OK);
	}

	@PutMapping("/update")

	public ResponseEntity<Course> updatedCustomers(@RequestBody Course course) {
		Course courseList = service.getUpdatedCourse(course);
		return new ResponseEntity<Course>(courseList, HttpStatus.OK);
	}
}
