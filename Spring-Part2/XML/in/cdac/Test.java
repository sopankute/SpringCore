/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.cdac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author CDAC
 */
public class Test {
    public static void main(String[] args) {
      Test t = new Test();
      //t.loadXML_IOC();
      t.loadAnnotation_IOC();
    }
    
    public void loadXML_IOC() {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);        
        Employee emp = factory.getBean(Employee.class);

        System.out.println("--" + emp);
        System.out.println(emp.getId()+"--" + emp.getName()+"---"+emp.getEmail());
        System.out.println("--" + emp.getAddress());

        //Address ads = factory.getBean(Address.class);
        //System.out.println("--" + ads);
    }
    
    public void loadAnnotation_IOC(){
        ApplicationContext ctx= new AnnotationConfigApplicationContext("in.cdac");
         Employee emp = ctx.getBean(Employee.class);
         System.out.println("========="+emp); 
         System.out.println("--" + emp.getAddress());
    }
}
