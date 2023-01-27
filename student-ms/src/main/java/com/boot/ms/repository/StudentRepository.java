package com.boot.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.ms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
