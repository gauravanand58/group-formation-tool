package com.advsdc.group4.Model;

public class Course {
	private String courseName, courseDescription;
	private int courseID;

	public Course(int courseID, String courseName, String courseDescription) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.courseDescription = courseDescription;
		
	}
	public Course() {
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseDescription() {
		return courseDescription;
	}
	
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public int getCourseID() {
		return courseID;
	}
	
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
}
