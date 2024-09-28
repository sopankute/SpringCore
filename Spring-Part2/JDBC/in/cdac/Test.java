/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.cdac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author CDAC
 */
public class Test {
    public static void main(String[] args) {
        Resource rs = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(rs);
        DBOperations dbops =  factory.getBean(DBOperations.class);
        
        
        Employee emp = factory.getBean(Employee.class);
        emp.setId(4);
        emp.setName("jsks1");
        emp.setEmail("jsks1@cdac.in");
        emp.setSalary(20000);
        
        //dbops.saveEmployeeDetails(emp);
        dbops.updateEmployeeDetails(emp);
        //dbops.deleteEmployeeDetails(3);
        dbops.getAllEmployees();
    }
}
