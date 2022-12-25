package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
