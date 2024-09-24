package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.MyConfig;
import com.model.Employee;
import com.service.EmployeeService;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        EmployeeService er =context.getBean(EmployeeService.class);
        Employee e = new Employee();
        e.setEname("Ganesh");
        e.setEdesignation("Backend Developer");
        e.setEsalary(35000);
        e.setEcompany("INFO");
        System.out.println(er.insertEmployee(e));
    }
}
