package com.boot.ms.model;

import java.util.List;

import com.boot.ms.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseResponse {
	
	private Student student;
	private List<Course> course;

}
