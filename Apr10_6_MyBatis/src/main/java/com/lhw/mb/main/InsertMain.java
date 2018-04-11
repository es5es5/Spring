package com.lhw.mb.main;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			// int -> BigDecimal
			BigDecimal a2 = new BigDecimal(a);

			System.out.print("시력 : ");
			double e = keyboard.nextDouble();
			BigDecimal e2 = new BigDecimal(e);

			System.out.print("생일(YYYYMMDD) : ");
			String b = keyboard.next();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date b2 = sdf.parse(b);

			Member m = new Member();
			m.setM_age(a2);
			m.setM_birthday(b2);
			m.setM_eye(e2);
			m.setM_name(n);

			if (ss.insert("lhw.join", m) == 1) {
				System.out.println("성공");
				ss.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
