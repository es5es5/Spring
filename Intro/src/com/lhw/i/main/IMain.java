package com.lhw.i.main;

import java.util.Scanner;

public class IMain {

	public static void main(String[] args) {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			double pointRate = 0.001;
			System.out.printf("���� �ݾ��� %.1f�ۼ�Ʈ�� ����Ʈ ����\n", pointRate * 100);
			
			System.out.println("���� �ݾ� : ");
			int price = keyboard.nextInt();
			int point = (int) (price * pointRate);
			System.out.printf("%d����Ʈ ����", point);
			
			System.out.println("���� ġ�� ����");
			keyboard.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			keyboard.close();
		}

	}

}
