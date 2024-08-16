package com.cglia.sms.service.impl;

import com.cglia.sms.model.Student;
import java.util.List;
import com.cglia.sms.service.Studentservice;
import com.cglia.sms.dao.StudentDao;
import com.cglia.sms.dao.impl.StudentImpl;

public class StudentServiceimpl implements Studentservice {
	
	StudentDao dao=new StudentImpl();

	@Override
	public Integer saveStu(Student student) {
		Integer id=dao.save(student);
		return id;
	}

	@Override
	public Student getStuById(Integer id) {
		Student stu=dao.getById(id);
		return stu;
	}
	@Override
	public int updatestu(Student student) {
		int count=dao.update(student);
		return count;
	}

	@Override
	public int deleteStuById(Integer id) {
		int count=dao.deleteById(id);
		return count;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list=dao.getAll();
		return list;
	}
	

}
