package com.boot.ms.Controller;

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
import com.boot.ms.entity.*;
import com.boot.ms.model.Course;
import com.boot.ms.model.FailureResponse;
import com.boot.ms.model.StudentCourseResponse;
import com.boot.ms.service.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getall")
	public ResponseEntity<List<Student>> getStudents() {
		return new ResponseEntity<List<Student>>(service.getStudents(), HttpStatus.OK);

	}

	@GetMapping("getstudent/{stdId}")
	public ResponseEntity<?> getStudent(@PathVariable int stdId) {
		Student student = service.getStudent(stdId);
		ResponseEntity<?> responseEntity = null;

		if (student == null) {
			responseEntity = new ResponseEntity<String>("No student present with given id  : " + stdId,
					HttpStatus.NOT_FOUND);

		} else {
			responseEntity = new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		return responseEntity;
	}

	@DeleteMapping("/delete/{stdId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int stdId) {
		service.deleteStudentById(stdId);
		return new ResponseEntity<String>("Deleted Succesfully", HttpStatus.OK);
	}

	@PostMapping("/insert")
	public ResponseEntity<Student> addCustomer(@RequestBody Student student) {
		return new ResponseEntity<Student>(service.addStudent(student), HttpStatus.OK);
	}

	@PutMapping("/update")

	public ResponseEntity<Student> updatedCustomers(@RequestBody Student student) {
		Student studentList = service.getUpdatedStudent(student);
		return new ResponseEntity<Student>(studentList, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getStudentandCourse/{courseId}")
	@HystrixCommand(fallbackMethod = "myFallBackMethod")
	public ResponseEntity<?> getCustometAndBank(@PathVariable int courseId) {

		Student student = service.getStudent(courseId);
		ResponseEntity<?> responseEntity = null;

		if (student == null) {
			responseEntity = new ResponseEntity<String>("No student present with the given id: " + courseId,
					HttpStatus.NOT_FOUND);
		} else {
			List<Course> courseList = restTemplate.getForObject("http://localhost:8888/course/getcourse/" + student.getId(),
					List.class);

			StudentCourseResponse response = new StudentCourseResponse();
			response.setStudent(student);
			response.setCourse(courseList);

			responseEntity = new ResponseEntity<StudentCourseResponse>(response, HttpStatus.OK);
		}
		return responseEntity;
	}

	public ResponseEntity<?> myFallBackMethod(@PathVariable int stdId) {
		Student student = service.getStudent(stdId);
		ResponseEntity<?> responseEntity = null;

		FailureResponse response = new FailureResponse();
		response.setStudent(student);
		response.setMessage("COURSE service is down due to maintainance");
		responseEntity = new ResponseEntity<FailureResponse>(response, HttpStatus.SERVICE_UNAVAILABLE);
		return responseEntity;
	}

}
