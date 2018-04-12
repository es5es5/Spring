package com.lhw.sdi.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class SDIMain {

	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("beans.xml"));

		Dog d = dlbf.getBean("d", Dog.class);
		Dog d2 = dlbf.getBean("d", Dog.class);
		System.out.println(d);
		System.out.println(d2);
		
		Dog dd = dlbf.getBean("d2", Dog.class);
		dd.printInfo();
		
		Dog ddd = dlbf.getBean("d3", Dog.class);
		Human h3 = dlbf.getBean("h3", Human.class);
		h3.say();
		Human h4 = dlbf.getBean("h4", Human.class);
		h4.say();
		
		CanCoffee cc = dlbf.getBean("cc", CanCoffee.class);
		
		cc.printInfo();
	}

}
