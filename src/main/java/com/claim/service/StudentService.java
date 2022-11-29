package com.claim.service;

import org.springframework.stereotype.Service;

import com.claim.entity.Student;

@Service
public class StudentService {
	public Student saveStudent(Student student) {
		Student [] students = new Student[4];
		
		Student s1 = new Student("Bill", "Cosby", "bill@mial.com", 65, "123");
		Student s2 = new Student("Maurice", "Kamto", "kamto@mial.com", 60, "123");
		Student s3 = new Student("Calibri", "Calibro", "calibri@mial.com", 45, "123");
		students[0]=s1;
		students[1]=s2;
		students[2]=s3;
		students[3]=student;
		
		return student;
	}
}
