package com.mohan.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mohan.sms.entity.Student;
import com.mohan.sms.service.StudentService;

@Controller
public class StudentController {
	private StudentService StudentService;

	public StudentController(com.mohan.sms.service.StudentService studentService) {
		super();
		StudentService = studentService;
	}
	@GetMapping(value="/students")
	public String listStudents(Model model) {
		 model.addAttribute("students",StudentService.getALLStudent());
		return("students");
	}
	@GetMapping(value="/students/new")
	public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return("create_student");
		
	}
	@PostMapping(value="/students")
	public String savestudent(@ModelAttribute("student")Student student) {
		
		StudentService.saveStudent(student);
		return"redirect:/students";
	}
	@GetMapping(value="/students/edit/{id}")
	public String editstudentform(@PathVariable Long id,Model model) {
		model.addAttribute("student", StudentService.getStudentById(id));
		return"edit_student";
		
	}
	
	@PostMapping(value="/students/{id}")
	public String updateStudent(@PathVariable Long id ,  @ModelAttribute("student")Student student,Model model) {
		//get student from the database
		Student existingstudent=StudentService.getStudentById(id);
		existingstudent.setFirstname(student.getFirstname());
		existingstudent.setLastname(student.getLastname());
		existingstudent.setEmail(student.getEmail());
		existingstudent.setId(student.getId());
		
		//save updated student object
		StudentService.updateStudent(existingstudent);
		return"redirect:/students";
		
	}
	//handler method to delete record
	@GetMapping(value="/students/{id}")
	public String deletestudent(@PathVariable Long id) {
		StudentService.deleteStudentById(id);
		return"redirect:/students";
		
	}

}
