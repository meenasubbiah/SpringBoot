package com.virtusa.myapp.students;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	
	@RequestMapping("/")
	public String hello(){
		return "Index";
		//return "Welcome "+name;
	}
	
	/*@Cacheable("getAllstudents")*/
	@RequestMapping("/students")
	public String getAllStudents(Model model){
		model.addAttribute("students",studentService.getStudents());
		return "ViewAllStudents";
	}
	
	/*@Cacheable("getstudent")
	@RequestMapping("/student/{id}")
	public Student getStudent(@PathVariable int id){
		return studentService.getStudent(id);	 
	}*/
	
	@RequestMapping("/addStudent")
	public String getStudent(Model model){
		model.addAttribute("student",new Student());
		return "AddStudent";
	}
	@PostMapping("/addStudentResult")
	public String addStudent(@ModelAttribute Student student){
		studentService.addStudent(student);
		return "AddStudentResult";	 
	}
	
	@RequestMapping("/getStudentById")
	public String welcome(Model model){
		model.addAttribute("student",new Student());
		return "GetStudentId";
	}
	@PostMapping("/viewStudentById")
	public String welcome(@ModelAttribute Student student,Model model){
		System.out.print(student);
		model.addAttribute("student",studentService.getStudent(student.getId()));
		return "ViewStudentById";
	}
	
	/*@CachePut(key="#student.id")*/
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student student,Model model){
		model.addAttribute("student",studentService.getStudent(student.getId()));
		return "UpdateStudent";
			 
	}
	@PostMapping("/updateStudentResult")
	public String updateStudentResult(@ModelAttribute Student student,Model model){
		System.out.print(student);
		studentService.updateStudent(student, student.getId());
		/*model.addAttribute("student",studentService.getStudent(student.getId()));*/
		return "Index";	
	}
	
	/*@CacheEvict(key="#student.id")*/
	@RequestMapping("/deleteStudent")
	public String deleteStudent(Model model){
		model.addAttribute("student",new Student());
		return "DeleteStudent";
		//studentService.deleteStudent(id);	 
	}
	
	@PostMapping("/deleteStudentResult")
	public String deleteStudentResult(@ModelAttribute Student student){
		studentService.deleteStudent(student.getId());
		return "Index";
	}
	

}
