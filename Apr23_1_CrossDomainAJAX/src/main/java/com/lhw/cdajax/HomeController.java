package com.lhw.cdajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@Autowired private DAO dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/movie.get", method=RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody String movieGet(HttpServletRequest request, HttpServletResponse response) {
		dao.getNaverMovieData(request, response);
		return dao.getNaverMovieData(request, response);
	}
	
}
