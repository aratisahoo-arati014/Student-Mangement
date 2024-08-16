package com.cglia.sms.dao;

import java.util.List;
import com.cglia.sms.model.Student;

public interface StudentDao {
	
    public Integer save(Student student);
	
	public Student getById(Integer id);
	
	public int update(Student student);
	
	public int deleteById(Integer id);
	
	public List<Student> getAll();

}
