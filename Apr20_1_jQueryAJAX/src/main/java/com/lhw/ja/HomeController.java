package com.lhw.ja;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired
	private DAO dao;

	@RequestMapping(value = "/menu.get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Menus menuGet(HttpServletRequest request, HttpServletResponse response) {
		return dao.getAllMenu(request, response);
	}
	
	@RequestMapping(value = "/menu.search.price", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Menus msp(Menu m, HttpServletRequest request, HttpServletResponse response) {
		return dao.sMenuByPrice(m, request, response);
	}
	
	@RequestMapping(value = "/menu.search.name", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Menus msn(Menu m, HttpServletRequest request, HttpServletResponse response) {
		return dao.sMenuByName(m, request, response);
	}
	
	@RequestMapping(value = "/student.getAll", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Students sGA(HttpServletRequest request, HttpServletResponse response) {
		return dao.getAllStudent(request, response);
	}
	
	@RequestMapping(value = "/student.getAllJSONP", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String sGAP(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cb = request.getParameter("callback");
			Students ss = dao.getAllStudent(request, response);
			
			// Java객체를 json으로 바꿔줄 객체
			ObjectMapper om = new ObjectMapper();
			String resBody = cb + "(" + new String(om.writeValueAsString(ss)) + ")";
			
			return resBody;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		//JSONP(JSON with Padding)
		//		서버쪽에서 설정
		//		응답내용 : JSON -> 응답내용 : JavaScript함수
		//		파라메터 하나 지정(callback)
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	
}
