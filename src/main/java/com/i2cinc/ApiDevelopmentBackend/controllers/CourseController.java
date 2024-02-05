package com.i2cinc.ApiDevelopmentBackend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.i2cinc.ApiDevelopmentBackend.customexceptions.CourseNotFoundException;
import com.i2cinc.ApiDevelopmentBackend.entity.Course;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CourseController {
	ArrayList<Course> courses = new ArrayList<>();

	@GetMapping("/")
	public String getMethodName() {
		return "<h2>Spring Boot App RestApi's</h2>";
	}

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		// Creating five Course objects
		Course course1 = new Course(101, "Introduction to Programming", "Professor Smith");
		Course course2 = new Course(201, "Calculus II", "Professor Johnson");
		Course course3 = new Course(301, "Advanced Writing", "Professor Davis");
		Course course4 = new Course(101, "Physics Fundamentals", "Professor White");
		Course course5 = new Course(200, "World History", "Professor Brown");

		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
		courses.add(course5);

		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable int id) throws CourseNotFoundException {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseCode() == id) {
				return new ResponseEntity<>(courses.get(i), HttpStatus.OK);
			}
		}
		throw new CourseNotFoundException("Course not found with id: " + id);
	}
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable int id) throws CourseNotFoundException {
		ArrayList<Course> newCourses = new ArrayList<>()
;		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseCode() != id) {
				newCourses.add(courses.get(i));
			}
		}
		courses = newCourses;
		return  new ResponseEntity("Course with id: " + id + "deleted ",HttpStatus.OK);
	}
	

}
