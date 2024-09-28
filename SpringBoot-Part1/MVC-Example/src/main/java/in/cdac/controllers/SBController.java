package in.cdac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.cdac.dao.Employee;

@Controller
public class SBController {

	@RequestMapping("/")
	public String showRegistrationForm() {
		
		return "register";
	}
	
	@RequestMapping("/register")
	public ModelAndView getEmployeeDetails(Employee emp, ModelAndView mv) {
		mv.addObject("msg", emp.toString());
		mv.setViewName("success");
		return mv;
	}
}
