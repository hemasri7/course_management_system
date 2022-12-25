package com.axis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.StudentDto;
import com.axis.exception.IdNotFoundException;
import com.axis.model.Student;
import com.axis.repository.StudentRepository;
import com.axis.service.StudentService;
import com.axis.utils.AppConstants;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	
	
	private StudentDto convertToDto(Student student2) {
		StudentDto studentDto=new ModelMapper().map(student2,StudentDto.class);
		return studentDto;
	}
	private Student convertToModel(StudentDto studentDto) {
		Student student=new ModelMapper().map(studentDto, Student.class);
		return student;
	}
	@Override
	public StudentDto addStudent(StudentDto studentDto) {
		Student student=studentRepository.save(convertToModel(studentDto));
		return convertToDto(student);
	}
	@Override
	public List<StudentDto> getAllStudents() {
		List<StudentDto> studentDto1=new ArrayList<>();
		List<Student> student1=studentRepository.findAll();
		for(Student student:student1) {
			studentDto1.add(convertToDto(student));
		}
		return studentDto1;
	}
	@Override
	public StudentDto getStudentById(int id) {
		// TODO Auto-generated method stub
		Student student=studentRepository.findById(id).orElseThrow((()->new IdNotFoundException(AppConstants.ID_NOT_FOUND_MESSAGE)));
		return convertToDto(student);
	}
	@Override
	public String deleteById(int id) {
		Student student=studentRepository.findById(id).orElseThrow((()->new IdNotFoundException(AppConstants.ID_NOT_FOUND_MESSAGE)));
		studentRepository.delete(student);
		return AppConstants.DELETE_MESSAGE;
	}
	@Override
	public StudentDto updateStudent(int id, StudentDto studentDto) {
		Student student=studentRepository.findById(id).orElseThrow((()->new IdNotFoundException(AppConstants.ID_NOT_FOUND_MESSAGE)));
		student.setId(studentDto.getId());
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setPhoneNumber(studentDto.getPhoneNumber());
		return convertToDto(student);
	}
	
	
	
}
	
