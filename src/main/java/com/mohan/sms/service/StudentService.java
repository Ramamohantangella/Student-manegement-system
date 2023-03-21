package com.mohan.sms.service;

import java.util.List;

import com.mohan.sms.entity.Student;

public interface StudentService {
	List<Student> getALLStudent();
	
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);

}
