package com.axis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Course;
@Repository

public interface CourseRepository extends JpaRepository<Course,String>{
	

}
