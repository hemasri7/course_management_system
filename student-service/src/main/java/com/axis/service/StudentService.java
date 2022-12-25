package com.axis.service;


import java.util.List;

import com.axis.dto.StudentDto;

public interface StudentService {
	public StudentDto addStudent(StudentDto studentDto); 
	public List<StudentDto> getAllStudents();
	public StudentDto getStudentById(int id);
	public StudentDto updateStudent(int id,StudentDto studentDto);
	public String deleteById(int id);

}
