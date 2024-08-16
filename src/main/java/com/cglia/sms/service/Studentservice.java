package com.cglia.sms.service;

import java.util.List;

import com.cglia.sms.model.Student;

public interface Studentservice {
	
	public Integer saveStu(Student student);

	public Student getStuById(Integer id);

	public int updatestu(Student student);

	public int deleteStuById(Integer id);

	public List<Student> getAllStudents();

	
}

