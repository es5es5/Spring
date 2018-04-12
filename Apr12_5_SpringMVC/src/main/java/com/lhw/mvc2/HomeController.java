package com.lhw.mvc2;

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
	private Doctor d1;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

//	@RequestMapping(value = "bimando.calculate", method = RequestMethod.GET)
//	public String bimandoCalc(
//			@RequestParam(value = "n") String n,
//			@RequestParam(value = "h") int h
//			) {
//		System.out.println(n);
//		System.out.println(h);
//		return "output";
//	}
	
	@RequestMapping(value = "bimando.calculate", method = RequestMethod.POST)
	public String bimandoCalc(Human h) {
		
		d1.test();
		
		return "output";
	}
	
}
