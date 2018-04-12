package com.lhw.sdi.main;

import java.util.ArrayList;
import java.util.HashMap;

public class CanCoffee {
	// 재료명들
	private ArrayList<String> jaeryo;
	// 영양정보들
	private HashMap<String, Double> info;
	
	public CanCoffee() {
		// TODO Auto-generated constructor stub
	}

	public CanCoffee(ArrayList<String> jaeryo, HashMap<String, Double> info) {
		super();
		this.jaeryo = jaeryo;
		this.info = info;
	}

	public ArrayList<String> getJaeryo() {
		return jaeryo;
	}

	public void setJaeryo(ArrayList<String> jaeryo) {
		this.jaeryo = jaeryo;
	}

	public HashMap<String, Double> getInfo() {
		return info;
	}

	public void setInfo(HashMap<String, Double> info) {
		this.info = info;
	}
	
	public void printInfo() {
		for(String s : jaeryo) {
			System.out.println(s);
		}
		System.out.println("----");
		System.out.println(info.get("탄수화물"));
		System.out.println(info.get("단백질"));
		System.out.println(info.get("지방"));
	}
}
