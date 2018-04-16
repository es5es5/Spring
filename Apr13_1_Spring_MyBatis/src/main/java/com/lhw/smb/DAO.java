package com.lhw.smb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// servlet-context.xml에 객체 하나 만들어짐
@Service
public class DAO {

	@Autowired
	private SqlSession ss;
	
	public void searchMenu(Menu sda, HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("menus", ss.getMapper(Mapper.class).searchMenu(sda));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllMenu(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 만들어 놓은 인터페이스 불러다가
			Mapper mp = ss.getMapper(Mapper.class);
			
			// 인터페이스에 있는 메소드 호출
			List<Menu> menus = mp.showMenu();
			request.setAttribute("menus", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reg(Menu m,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			// 만들어 놓은 interface 부르기
			Mapper mp = ss.getMapper(Mapper.class);
		
			if(mp.regMenu(m)==1) {
				request.setAttribute("r", "성공");
			} else {
				request.setAttribute("r", "실패");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "실패");
		}
	}
}
