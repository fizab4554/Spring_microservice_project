package com.boot.ms.model;

import com.boot.ms.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailureResponse {

	private Student student;
	private String message;

}