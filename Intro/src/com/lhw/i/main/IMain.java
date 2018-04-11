package com.lhw.i.main;

import java.util.Scanner;

public class IMain {

	public static void main(String[] args) {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			double pointRate = 0.001;
			System.out.printf("구매 금액의 %.1f퍼센트가 포인트 적립\n", pointRate * 100);
			
			System.out.println("구매 금액 : ");
			int price = keyboard.nextInt();
			int point = (int) (price * pointRate);
			System.out.printf("%d포인트 적립", point);
			
			System.out.println("뭐라도 치고 엔터");
			keyboard.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			keyboard.close();
		}

	}

}
