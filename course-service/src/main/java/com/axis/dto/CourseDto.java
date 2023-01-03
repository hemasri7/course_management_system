package com.axis.dto;

import java.sql.Date;
import jakarta.persistence.Id;
public class CourseDto {
	@Id
	private String courseId;
	private String courseName;
	private Date startDate;
	private Date endDate;
	private long payment;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getPayment() {
		return payment;
	}
	public void setPayment(long payment) {
		this.payment = payment;
	}
	public CourseDto(String courseId, String courseName, Date startDate, Date endDate, long payment) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.payment = payment;
	}
	public CourseDto() {
		super();
	}
	
	

}
