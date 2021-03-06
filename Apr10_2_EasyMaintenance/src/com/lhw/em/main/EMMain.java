package com.lhw.em.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

// Spring : 유지보수 편하게 하는 프레임워크

public class EMMain {

	public static void main(String[] args) {
		// 외부 파일에서 불러오기
		BufferedReader br = null;
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);

			FileReader fr = new FileReader("C:\\Users\\soldesk\\Desktop\\pointRate.txt");
			br = new BufferedReader(fr);
			String pr = br.readLine();
			double pointRate = Double.parseDouble(pr);

			System.out.printf("적립률은 %.1f퍼센트\n", pointRate * 100);
			System.out.println("금액 : ");
			int price = keyboard.nextInt();

			int point = (int) (price * pointRate);
			System.out.printf("%d포인트 적립\n", point);

			System.out.println("아무 말이나 치세요.");
			keyboard.next();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			keyboard.close();
			try {br.close();} catch (Exception e) {}
		}
	}

}
