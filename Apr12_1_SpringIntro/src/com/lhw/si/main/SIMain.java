package com.lhw.si.main;

public class SIMain {

	public static void main(String[] args) {
		Ironman i = new Ironman();
		i.attack();
		
		// ������(���� Ÿ�� ������ ���� Ÿ�� ��ü �ֱ�)
		Hero h = new Batman();
		h.attack();
	}
	
	

}
