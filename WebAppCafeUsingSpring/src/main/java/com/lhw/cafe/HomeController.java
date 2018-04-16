package com.lhw.cafe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhw.cafe.member.MemberDAO;

@Controller
public class HomeController {
	
	@Autowired private MemberDAO mDAO;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {
		mDAO.loginCheck(request, response);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value="/home.go", method = RequestMethod.GET)
	public String homeGo(HttpServletRequest request, HttpServletResponse response) {
		mDAO.loginCheck(request, response);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	

}
