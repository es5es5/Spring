package com.lhw.smb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
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
	private DAO d;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/menu.reg.go", method=RequestMethod.GET)
	public String regGo() {
		return "insert";
	}
	
	@RequestMapping(value = "/menu.reg.do", method=RequestMethod.GET)
	public String regDo(Menu m, HttpServletRequest request, HttpServletResponse response) {
		d.reg(m, request, response);
		
		return "insert";
	}
	
	@RequestMapping(value = "/menu.show", method=RequestMethod.GET)
	public String showMenu(Menu m, HttpServletRequest request, HttpServletResponse response) {
		d.getAllMenu(request, response);
		return "select";
	}
	
	@RequestMapping(value = "/menu.search", method=RequestMethod.GET)
	public String searchMenu(Menu m, HttpServletRequest request, HttpServletResponse response) {
		d.searchMenu(m, request, response);
		return "select";
	}
	
	
	
}
