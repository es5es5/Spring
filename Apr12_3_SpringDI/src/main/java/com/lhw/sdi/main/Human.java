package com.lhw.sdi.main;

public class Human {
	private String name;
	private int age;
	private double height;
	private double eye;

	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age, double height, double eye) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.eye = eye;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getEye() {
		return eye;
	}

	public void setEye(double eye) {
		this.eye = eye;
	}

	public void say() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(eye);
	}
}
