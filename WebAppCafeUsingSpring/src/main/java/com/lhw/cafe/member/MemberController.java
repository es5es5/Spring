package com.lhw.cafe.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO mDAO;
	
	

	@RequestMapping(value = "/join.go", method = RequestMethod.GET)
	public String joinGo(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("loginPage", "member/login.jsp");
		request.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String joinDo(Member m, HttpServletRequest request, HttpServletResponse response) {
		mDAO.join(m, request, response);

		request.setAttribute("loginPage", "member/login.jsp");
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginDo(Member m, HttpServletRequest request, HttpServletResponse response) {
		mDAO.login(m, request, response);
		mDAO.loginCheck(request, response);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		mDAO.logout(request, response);
		mDAO.loginCheck(request, response);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
}
