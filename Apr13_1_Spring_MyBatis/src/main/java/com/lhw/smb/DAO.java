package com.lhw.smb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// servlet-context.xml�� ��ü �ϳ� �������
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
			// ����� ���� �������̽� �ҷ��ٰ�
			Mapper mp = ss.getMapper(Mapper.class);
			
			// �������̽��� �ִ� �޼ҵ� ȣ��
			List<Menu> menus = mp.showMenu();
			request.setAttribute("menus", menus);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reg(Menu m,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			// ����� ���� interface �θ���
			Mapper mp = ss.getMapper(Mapper.class);
		
			if(mp.regMenu(m)==1) {
				request.setAttribute("r", "����");
			} else {
				request.setAttribute("r", "����");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "����");
		}
	}
}
