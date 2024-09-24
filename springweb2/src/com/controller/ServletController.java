package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServletController {
	
		@RequestMapping(value="/request1", method=RequestMethod.GET)
		public String meth1() {
			System.out.println("We got Request1");
			return "first.jsp";
		}
		
		@RequestMapping(value="/request2", method=RequestMethod.GET)
		public String meth2() {
			System.out.println("We got Request2");
			return "second.jsp";
		}
}
