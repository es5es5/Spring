package com.lhw.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// jsp
//		http://~~~~/프로젝트명/컨트롤러

// spring
// 	http://~~~~~/패키지 마지막자리/마음대로

@Controller // Spring이 컨트롤러로 인식
public class HomeController {
	
	
	// http://~~~~~~/패키지 마지막자리/tttt로 GET방식 요청하면
	@RequestMapping(value="tttt", method = RequestMethod.GET)
	// 이 메소드 호출
	public void test() {
		System.out.println("테스트");
	}
	
	@RequestMapping(value="aaaaa", method = RequestMethod.GET)
	public void aaa() {
		System.out.println("a");
	}
	
	@RequestMapping(value="bb", method = RequestMethod.GET)
	public void bbb() {
		System.out.println("b");
	}
	
	@RequestMapping(value="c", method = RequestMethod.GET)
	public void ccc() {
		System.out.println("c");
	}
	
	@RequestMapping(value="index.go", method = RequestMethod.GET)
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping(value="req.test", method = RequestMethod.GET)
	public String reqTest() {
		System.out.println("요청받음");
		return "index";
	}
	
	
}
