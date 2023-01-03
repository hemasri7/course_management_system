package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.CourseDto;
import com.axis.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@PostMapping("/addCourse")
	public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto){
		CourseDto courseDto1=courseService.addCourse(courseDto);
		return new ResponseEntity<CourseDto>(courseDto1,HttpStatus.CREATED);
	}
	@GetMapping("/courses")
	public ResponseEntity<List<CourseDto>> getAllCourses(){
		List<CourseDto>courses=courseService.getAllCourses();
		return new ResponseEntity<List<CourseDto>>(courses,HttpStatus.OK);
	}
	@GetMapping("/course")
	public ResponseEntity<CourseDto> getCourseById(@RequestParam(name="courseId") String courseId){
		CourseDto course=courseService.getCourseById(courseId);
		return new ResponseEntity<CourseDto>(course,HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCourseById(@RequestParam(name="courseId") String courseId){
		String message=courseService.deleteByCourseId(courseId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	@PutMapping("/update")
	public ResponseEntity<CourseDto> updateCourse(@RequestParam(name="courseId") String courseId,@RequestBody CourseDto courseDto){
		CourseDto courseDto2=courseService.updateCourse(courseId, courseDto);
		return new ResponseEntity<CourseDto>(courseDto2,HttpStatus.OK);
	}
}
