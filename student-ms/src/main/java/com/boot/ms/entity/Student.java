package com.boot.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student11")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@Column(name = "stdId")
	private int id;
	@Column(name = "stdName")
	private String stdName;
	@Column(name="courseId")
	private int courseId;
	
	public Student(String stdName, int courseId) {
		super();
		this.stdName = stdName;
		this.courseId = courseId;
	}

}
