package com.lhw.sdi.main;

public class Human2 {
	private String name;
	
	public Human2() {}

	public Human2(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void say() {
		System.out.println(name);
	}
}
