package com.i2cinc.ApiDevelopmentBackend.customexceptions;

public class CourseNotFoundException extends Exception {
	String message;
	public CourseNotFoundException(String msg) {
		super(msg);
		this.message = msg;
	}

}
