package com.lhw.mb.main;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

public class InsertMain {
	public static void main(String[] args) {
		try {
			SqlSession ss = DBManager.connect();
			Scanner keyboard = new Scanner(System.in);
			
			System.out.print("이름 : ");
			String n = keyboard.nextLine();
			
			System.out.print("나이 : ");
			int a = keyboard.nextInt();
			
			System.out.print("시력 : ");
			double e = keyboard.nextDouble();
			
			System.out.print("생일(YYYYMMDD) : ");
			String b = keyboard.next();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
