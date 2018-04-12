package com.lhw.mvc2;

import org.springframework.stereotype.Service;

@Service // servlet-context.xml에 자동 등록
public class Doctor {
	public void test() {
		System.out.println("asd");
	}
}
