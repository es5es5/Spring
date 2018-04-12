package com.lhw.si.main;

public class SIMain {

	public static void main(String[] args) {
		Ironman i = new Ironman();
		i.attack();
		
		// 다형성(상위 타입 변수에 하위 타입 객체 넣기)
		Hero h = new Batman();
		h.attack();
	}
	
	

}
