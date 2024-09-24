package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.MyConfig;
import com.dao.StudentDao;
import com.model.Student;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
       StudentDao sd = (StudentDao)context.getBean(StudentDao.class);
       Student s = new Student();
       s.setSname("Ashish");
       s.setScity("Nashik");
       s.setSpercentage(87.76);
       s.setSid(8);
//       System.out.println(sd.insertStudent(s));
       
//       System.out.println(sd.deleteStudent(7));
       
       System.out.println(sd.updateStudent(s,8));
    }
}