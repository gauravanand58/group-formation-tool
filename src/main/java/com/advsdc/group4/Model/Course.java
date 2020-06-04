package com.advsdc.group4.Model;

public class Course {
	private int courseID;
	private String courseName, courseDescription;

	public String getCourseName() {
		return courseName;
	}

	public Course(int courseID, String courseName, String courseDescription) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.courseDescription = courseDescription;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
}

