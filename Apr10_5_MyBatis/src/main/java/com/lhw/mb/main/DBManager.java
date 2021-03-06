package com.lhw.mb.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager {
	public static SqlSession connect() throws IOException {
		InputStream is = Resources.getResourceAsStream("config.xml");
		
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		
		return ssf.openSession();
	}
}
