package com.lhw.cafe.member;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;

	public void autologin(HttpServletRequest request, HttpServletResponse response) {
		// 이 컴퓨터에 만들어져있는 모든 쿠키들
		Cookie[] cookies = request.getCookies();

		// 만들어진 쿠키가 있을 때
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("cafe_AutoLoginID")) {
					String im_id = c.getValue();
					
					if (im_id != null) { // 로그아웃 안 누르고 집에 갔었으면
						Member m = new Member();
						m.setIm_id(im_id);
						
						// 세션에 있는 m으로 바로 로그인 때려버림
						Member dbM = ss.getMapper(MemberMapper.class).getMemberById(m);
						
						if (dbM != null) {
							request.getSession().setAttribute("loginMember", dbM);
							request.getSession().setMaxInactiveInterval(1200);
						}
					}
				}
			}
		}
	}

	public void join(Member m, HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/etc");

			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "euc-kr",
					new DefaultFileRenamePolicy());

			String im_img = mr.getFilesystemName("im_img");
			im_img = URLEncoder.encode(im_img, "euc-kr");
			im_img = im_img.replace("+", " ");

			m.setIm_id(mr.getParameter("im_id"));
			m.setIm_pw(mr.getParameter("im_pw"));
			m.setIm_name(mr.getParameter("im_name"));
			m.setIm_addr1(mr.getParameter("im_addr1"));
			m.setIm_addr2(mr.getParameter("im_addr2"));
			m.setIm_addr3(mr.getParameter("im_addr3"));
			m.setIm_img(im_img);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				request.setAttribute("r", "가입 성공");
			} else {
				request.setAttribute("r", "가입 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "가입 실패");
		}

	}

	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) {
		Member m = (Member) request.getSession().getAttribute("loginMember");

		if (m != null) {
			request.setAttribute("loginPage", "member/loginOK.jsp");
			return true;
		} else {
			request.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}

	public void login(Member m, HttpServletRequest request, HttpServletResponse response) {
		try {
			Member dbM = ss.getMapper(MemberMapper.class).getMemberById(m);

			if (dbM != null) {
				if (m.getIm_pw().equals(dbM.getIm_pw())) {
					request.setAttribute("r", "로그인 성공");

					// 로그인 성공했다면, 그 아이디 정보를 세션에.
					request.getSession().setAttribute("loginMember", dbM);
					request.getSession().setMaxInactiveInterval(1200);

					if (request.getParameter("im_autologin") != null) {
						Cookie c = new Cookie("cafe_AutoLoginID", dbM.getIm_id());
						c.setMaxAge(1 * 60 * 60 * 24);
					}

				} else {
					request.setAttribute("r", "비번 틀림");
				}
			} else {
				request.setAttribute("r", "그런 계정 없음");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB서버문제");
		}

	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("loginMember", null);

		// 이 컴퓨터에 만들어져있는 모든 쿠키들
		Cookie[] cookies = request.getCookies();

		// 만들어진 쿠키가 있을 때
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("cafe_AutoLoginID")) {
					c.setValue(null); // ID 값 삭제
					response.addCookie(c);
				}
			}
		}
	}
}
