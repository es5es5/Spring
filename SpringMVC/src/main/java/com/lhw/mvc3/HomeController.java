package com.lhw.mvc3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private Calculator c;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "input";
	}

	@RequestMapping(value = "/calculate.do", method = RequestMethod.GET)
	public String calculate(MyBean mb, HttpServletRequest request, HttpServletResponse response) {
		c.calc(mb, request, response);
		
		return "output";
	}

}
