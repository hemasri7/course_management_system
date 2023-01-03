package com.axis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.CourseDto;
import com.axis.exception.IdNotFoundException;
import com.axis.model.Course;
import com.axis.repository.CourseRepository;
import com.axis.service.CourseService;
import com.axis.utils.AppConstants;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;
	public CourseDto convertToDto(Course course) {
		CourseDto courseDto=new ModelMapper().map(course,CourseDto.class);
		return courseDto;
		
	}
	public Course convertToModel(CourseDto courseDto) {
		Course course=new ModelMapper().map(courseDto, Course.class);
		return course;
	}
	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		Course course1=courseRepository.save(convertToModel(courseDto));
		return convertToDto(course1);
	}
	@Override
	public List<CourseDto> getAllCourses() {
		List<CourseDto> courseDto1=new ArrayList<>();
		List<Course> course1=courseRepository.findAll();
		for(Course course:course1) {
			courseDto1.add(convertToDto(course));
		}
		return courseDto1;
	}
	@Override
	public CourseDto getCourseById(String courseId) {
		Course course2=courseRepository.findById(courseId).orElseThrow((()->new IdNotFoundException(AppConstants.ID_NOT_FOUND_MESSAGE)));
		return convertToDto(course2);
	}
	@Override
	public String deleteByCourseId(String courseId) {
		Course course=courseRepository.findById(courseId).orElseThrow((()->new IdNotFoundException(AppConstants.ID_NOT_FOUND_MESSAGE)));
		courseRepository.delete(course);
		return AppConstants.DELETE_MESSAGE;
	}
	@Override
	public CourseDto updateCourse(String courseId, CourseDto courseDto) {
		Course course5=courseRepository.findById(courseId).orElseThrow((()->new IdNotFoundException(AppConstants.ID_NOT_FOUND_MESSAGE)));
		course5.setCourseId(courseDto.getCourseId());
		course5.setCourseName(courseDto.getCourseName());
		course5.setStartDate(courseDto.getStartDate());
		course5.setEndDate(courseDto.getEndDate());
		course5.setPayment(courseDto.getPayment());
		return convertToDto(course5);
	}
	
	
}
