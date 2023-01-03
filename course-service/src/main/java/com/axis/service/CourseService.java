package com.axis.service;

import java.util.List;

import com.axis.dto.CourseDto;

public interface CourseService {
	public CourseDto addCourse(CourseDto courseDto);
	public List<CourseDto> getAllCourses();
	public CourseDto getCourseById(String courseId);
	public String deleteByCourseId(String courseId);
	public CourseDto updateCourse(String courseId,CourseDto courseDto);

}
