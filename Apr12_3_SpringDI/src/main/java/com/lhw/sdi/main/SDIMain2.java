package com.lhw.sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SDIMain2 {

	public static void main(String[] args) {
		
		// 등록된거 그냥 다 생김
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		
		
		Dog d = aac.getBean("d", Dog.class);
		
		Tumbler t = aac.getBean("t", Tumbler.class);
		t.printInfo();
		
		aac.registerShutdownHook();
		aac.close();
	}

}
