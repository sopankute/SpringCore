package in.cdac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.cdac.util.Employee;

@SpringBootApplication
public class FirstSpBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = 
				SpringApplication.run(FirstSpBootApplication.class, args);
		
		Employee emp = ctx.getBean(Employee.class);
		
		System.out.println("---"+emp);
		System.out.println("---"+emp.getAddress());
		
		Employee emp2 = ctx.getBean(Employee.class);
		
		System.out.println("---"+emp2);
		System.out.println("---"+emp2.getAddress());
	}

}
