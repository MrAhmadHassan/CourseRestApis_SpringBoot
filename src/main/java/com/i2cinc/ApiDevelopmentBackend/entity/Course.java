package com.i2cinc.ApiDevelopmentBackend.entity;

public class Course {

	private int courseCode;
    private String courseName;
    private String instructor;

    public Course(int i, String courseName, String instructor) {
        this.courseCode = i;
        this.courseName = courseName;
        this.instructor = instructor;
    }

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
    
    
}
