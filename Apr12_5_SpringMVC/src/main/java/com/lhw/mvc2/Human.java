package com.lhw.mvc2;


// 요청파라미터명 = 멤버변수명
public class Human {
	private String n;
	private int h;
	private double w;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String n, int h, double w) {
		super();
		this.n = n;
		this.h = h;
		this.w = w;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}
}
