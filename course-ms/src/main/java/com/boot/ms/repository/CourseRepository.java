package com.boot.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;
import com.boot.ms.entity.*;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}

