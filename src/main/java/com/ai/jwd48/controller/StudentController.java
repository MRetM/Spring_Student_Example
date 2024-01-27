package com.ai.jwd48.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.jwd48.model.Student;
import com.ai.jwd48.services.StudentService;




@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public String searchView(ModelMap model) {

		List<Student> list = studentService.findAllStudent();
		
		model.addAttribute("studentList",list);
		
		return "student";
	}
	
	
	@RequestMapping(value="/setupStudentRegister", method=RequestMethod.GET)
	public ModelAndView studRegister(ModelMap model) {
		return new ModelAndView("studentRegister","studentBean", new Student()); //bean name ka kyike tar pay
	}
	
	@RequestMapping(value="/StudentRegister", method=RequestMethod.POST)
	public String studentRegister(@ModelAttribute("studentBean") Student sb, ModelMap model) {  //a paw ka pay htar tak name ko pyan call bean name
		Student student = new Student();
		student.setName(sb.getName());
		student.setEmail(sb.getEmail());
		student.setAge(sb.getAge());
		student.setAddress(sb.getAddress());
		student.setPhoneNumber(sb.getPhoneNumber());
		student.setFatherName(sb.getFatherName());
		student.setGender(sb.getGender());
		int result = studentService.saveStudent(student);
		if(result ==0) {
			System.out.println("ssdsdsd");
			model.addAttribute("error", "this is error");
			return "/studentRegister";
		}
		 return "redirect:/studentList";
		
	}
	
	@RequestMapping(value="/studentUpdate/{studentId}",method=RequestMethod.GET)
	public ModelAndView updateView(
			@PathVariable int studentId,
			ModelMap model
			) {
		Student selectedStudent = studentService.findStudentById(studentId);
		  model.addAttribute("selectedStudent", selectedStudent);
		return new ModelAndView("studentUpdate","studentUpdateBean",selectedStudent);
	}
	
	@RequestMapping(value="/setUpStudentUpdate", method=RequestMethod.POST)
	public String studentUpdate(@ModelAttribute("studentUpdateBean") Student sb, ModelMap model) {  //a paw ka pay htar tak name ko pyan call bean name
		Student student = new Student();
		student.setName(sb.getName());
		student.setEmail(sb.getEmail());
		student.setAge(sb.getAge());
		student.setAddress(sb.getAddress());
		student.setPhoneNumber(sb.getPhoneNumber());
		student.setFatherName(sb.getFatherName());
		student.setGender(sb.getGender());
		student.setId(sb.getId());
		if(sb.getId() == 0) {
			System.out.println("id is null");
		}
		 
		int result = studentService.update(student);
		if(result ==0) {
			System.out.println("ssdsdsd");
			model.addAttribute("error", "this is error");
			return "/studentUpdate";
		}
		 return "redirect:/studentList";
		
		   }
	
	 @RequestMapping(value = "/deleteStudent/{studentId}", method = RequestMethod.GET)
	    public String deleteStudent(@PathVariable int studentId) {
	        
	        int result = studentService.delete(studentId);
	        if (result > 0) {
	   		 return "redirect:/studentList";
	        } else {
	   		 return "/studentList";
	        }
	    
	}

	}

	
	
	


