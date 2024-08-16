package com.cglia.sms.controller;

import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.cglia.sms.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cglia.sms.service.Studentservice;

@Controller(value="smsController")
public class SMSController {
	
	@Autowired
	private Studentservice service;
	
	@GetMapping("/home")
	public String showHome() {
		return "Home";
	}
	
	@PostMapping("/add")
	public String addStudent(HttpServletRequest request) {
		return "Addstudent";
	}
	//To-Do     ---double posting problem
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student stu, HttpServletRequest request, RedirectAttributes attrs) {
		System.out.println(stu);
		Integer id=service.saveStu(stu);
		attrs.addFlashAttribute("stuid", id);
		if(id>0) {
			attrs.addFlashAttribute("successmsg","Student saved successfully with ID:"+id);
		}else {
			attrs.addFlashAttribute("failuremsg","System problem. Please contact Help desk.");
		}
		return "redirect:/getAll";
	}
	
	@RequestMapping(path="/getAll", method=RequestMethod.GET)
	public String getAllStudents(HttpServletRequest request) {
		List<Student> list=service.getAllStudents();
		request.setAttribute("Studentlist",list);
		System.out.println(list);
		return "Showallstudent";
	}
	
	@GetMapping("/getById")
	public String getStudentByID(@RequestParam("id") Integer id, HttpServletRequest request) {
		Student stu=service.getStuById(id);
		request.setAttribute("stu", stu);
		return "UpdateStudent";
	}
	
	@PostMapping("upadtestudent")
	public String updateStudent(@ModelAttribute Student stu, RedirectAttributes attrs) {
		int count=service.updatestu(stu);
		attrs.addFlashAttribute("updatecount", count);
		if(count>0) {
			attrs.addFlashAttribute("updated","Student with ID: "+stu.getId()+" is updated successfully.");
		}else {
			attrs.addFlashAttribute("notupdated","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
	}
	
	@PostMapping("/delete")
	public String deleteStudent(HttpServletRequest request, RedirectAttributes attrs) {
		Integer id=null;
		int count=0;
		if(Objects.nonNull(request.getParameter("idtodelete"))) {
			id=Integer.parseInt(request.getParameter("idtodelete"));
		}
		
		if(Objects.nonNull(id)) {
			count=service.deleteStuById(id);
			attrs.addFlashAttribute("deletecount", count);
		}
		
		if(count>0){
			attrs.addFlashAttribute("deleted","Student with ID: "+id+" is deleted successfully.");
		}else {
			attrs.addFlashAttribute("notdeleted","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
	}
}