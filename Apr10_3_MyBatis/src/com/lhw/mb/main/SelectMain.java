package com.lhw.mb.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain {

	public static void main(String[] args) {

		try {
			String cfgName = "config.xml";
			InputStream is = Resources.getResourceAsStream(cfgName);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			SqlSession ss = ssf.openSession();
			
			List<Product> products = ss.selectList("lhw.getProduct");
			
			for (Product product : products) {
				System.out.println(product.getP_name());
				System.out.println(product.getP_price());
			}
			
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
