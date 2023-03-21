package com.mohan.sms.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mohan.sms.entity.Student;
import com.mohan.sms.repository.StudentRepository;
import com.mohan.sms.service.StudentService;
@Service
public class StudentServiceimpl implements StudentService {
	
	private StudentRepository StudentRepository;
	
	public StudentServiceimpl(StudentRepository studentRepository) {
		super();
		StudentRepository = studentRepository;
	}

	@Override
	public List<Student> getALLStudent() {
		
		return StudentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return StudentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		
		return StudentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return StudentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		StudentRepository.deleteById(id);
		
	}

}
