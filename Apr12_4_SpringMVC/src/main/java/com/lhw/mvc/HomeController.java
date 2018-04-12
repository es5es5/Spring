package com.lhw.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// jsp
//		http://~~~~/������Ʈ��/��Ʈ�ѷ�

// spring
// 	http://~~~~~/��Ű�� �������ڸ�/�������

@Controller // Spring�� ��Ʈ�ѷ��� �ν�
public class HomeController {
	
	
	// http://~~~~~~/��Ű�� �������ڸ�/tttt�� GET��� ��û�ϸ�
	@RequestMapping(value="tttt", method = RequestMethod.GET)
	// �� �޼ҵ� ȣ��
	public void test() {
		System.out.println("�׽�Ʈ");
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
		System.out.println("��û����");
		return "index";
	}
	
	
}
