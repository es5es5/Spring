package com.lhw.sdi.main;
// 개
	// 이름
	// 나이

	// 정보출력
public class Dog {
	private String name;
	private int age;
	
	public Dog() {
		System.out.println("새로운 개 생성 : 기본 생성자");
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("새로운 개 생성 : 오버로딩된 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setName");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("setAge");
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
	}
}
