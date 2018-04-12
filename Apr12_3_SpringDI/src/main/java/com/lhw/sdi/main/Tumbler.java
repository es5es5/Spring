package com.lhw.sdi.main;

import org.springframework.beans.factory.annotation.Autowired;

public class Tumbler {
	
	@Autowired // beans.xml에 있는거 자동으로 연결
	private Human2 from;

	public Tumbler() {}

	public Tumbler(Human2 from) {
		super();
		this.from = from;
	}

	public Human2 getFrom() {
		return from;
	}

	public void setFrom(Human2 from) {
		this.from = from;
	}

	public void printInfo() {
		from.say();
	}
}
