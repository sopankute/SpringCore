package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Student;


@Repository
public class StudentDao {
	@Autowired
	private SessionFactory sf;
	
	public int insertStudent(Student s) {
		return (int)sf.openSession().save(s);
	}
}
