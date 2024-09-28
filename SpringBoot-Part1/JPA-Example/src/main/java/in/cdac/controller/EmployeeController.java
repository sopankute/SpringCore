package in.cdac.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.cdac.db.Employee;
import in.cdac.repo.EmployeeRepository;


@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;
	
	@RequestMapping("/")
	public String showRegistrationForm() {		
		return "register";
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView getEmployeeDetails(Employee emp, ModelAndView mv) {
		
		repo.save(emp);
		
		mv.addObject("msg", emp.toString());
		mv.setViewName("success");
		return mv;
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public ModelAndView getEmployeeDetails(int empID, ModelAndView mv) {		
		Optional<Employee> emp = repo.findById(empID);		
		System.out.println(emp.get().getEmpEmail());
		
		repo.delete(emp.get());
		
		mv.addObject("msg", empID+" employee ID deleted");
		mv.setViewName("success");
		return mv;
	}
	
}
