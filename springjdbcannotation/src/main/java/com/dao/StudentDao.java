package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.model.Student;
import com.model.StudentRowMapper;

@Component
public class StudentDao {
	@Autowired
	public JdbcTemplate j;
	
	public int insertStudent(Student s) {
		String query = "insert into student(sname,scity,spercentage) values(?,?,?)";
		return j.update(query, new Object[] {s.getSname(), s.getScity(), s.getSpercentage()});
	}
	
	public int deleteStudent(int sid) {
		String query = "delete from student where sid=?";
		return j.update(query,new Object[]{sid});
	}
	
	public int updateStudent(Student s, int sid) {
		String query = "update student set sname=?, scity=?, spercentage=? where sid=?";
		return j.update(query,new Object[] {s.getSname(), s.getScity(),s.getSpercentage(),s.getSid()});
	}
//	public Student findStudent(int sid) {
//		String query1 = "select * from student where sid=?";
//		return j.query(query1,new Object[] {sid}, new StudentRowMapper()).get(0);
//}
}