package com.lhw.ja;

import java.lang.reflect.Member;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DAO {

	@Autowired
	private SqlSession ss;

	public Menus getAllMenu(HttpServletRequest request, HttpServletResponse response) {
		List<Menu> menus = ss.getMapper(Mapper.class).getAllMenu();

		Menus menus2 = new Menus(menus);

		return menus2;
	}

	public Menus sMenuByPrice(Menu m, HttpServletRequest request, HttpServletResponse response) {
		return new Menus(ss.getMapper(Mapper.class).searchMenuByPrice(m));
	}
	
	public Menus sMenuByName(Menu m, HttpServletRequest request, HttpServletResponse response) {
		try {
			String m_name = m.getM_name();
			m_name = URLDecoder.decode(m_name, "utf-8");
			m.setM_name(m_name);
			return new Menus(ss.getMapper(Mapper.class).searchMenuByPrice(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Menus(ss.getMapper(Mapper.class).searchMenuByPrice(m));
	}
	
}