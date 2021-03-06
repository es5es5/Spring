package com.lhw.mb.main;

import java.io.InputStream;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// MyBatis( 구) iBatis)
// 		DB ORM Framework
//		Object Relational Mapping
//		외부 파일에 DB관련된 것들을 쓰게
//			DB서버 정보 config.xml
//			SQL mapper.xml

// 			닫기 자동


public class ConnectMain {
	public static void main(String[] args) {
		
		try {
			// DB서버정보가 있는 파일명
			String cfgName = "config.xml";
			
			// 거기 있는 데이터를 빼올 수 있게
			InputStream is = Resources.getResourceAsStream(cfgName);
			
			//
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			
			SqlSessionFactory ssf = ssfb.build(is);
			
			SqlSession ss = ssf.openSession();
			
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
