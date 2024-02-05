package com.i2cinc.ApiDevelopmentBackend.globalexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.i2cinc.ApiDevelopmentBackend.customexceptions.CourseNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<String> handleCourseNotFoundException(CourseNotFoundException e) {
		// Handle CourseNotFoundException
		return new ResponseEntity<>("Course not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleOtherExceptions(Exception e) {
		// Handle other exceptions
		return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}