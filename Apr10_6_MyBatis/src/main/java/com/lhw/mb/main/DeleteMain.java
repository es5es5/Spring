package com.lhw.mb.main;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

public class DeleteMain {
	public static void main(String[] args) {
		try {
			SqlSession ss = DBManager.connect();
			Scanner keyboard = new Scanner(System.in);

			System.out.print("�̸� : ");
			String n = keyboard.nextLine();


			Member m = new Member();
			m.setM_name(n);

			if (ss.delete("lhw.bye", m) >= 1) {
				System.out.println("����");
				ss.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
