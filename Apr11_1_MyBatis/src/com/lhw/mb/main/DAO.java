package com.lhw.mb.main;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAO {
	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			SqlSession ss = DBManager.connect();
			
			String p_no = request.getParameter("p_no");
			Product p = new Product();
			p.setP_no(new BigDecimal(p_no));
			
			Product pp = ss.selectOne("lhw.getProduct", p);
			String p_img = pp.getP_img();
			p_img = URLDecoder.decode(p_img, "euc-kr");
			
			String path = request.getServletContext().getRealPath("img");
			
			if (ss.delete("lhw.bye", p)==1) {
				request.setAttribute("r", "삭제성공");
				ss.commit();
				
				File f = new File(path + "/" + p_img);
				f.delete();
				
				System.out.println(path);
			} else {
				request.setAttribute("r", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			SqlSession ss = DBManager.connect();
			
			String i = request.getParameter("increase");
			String s = request.getParameter("search");
			
			ForUpdate fu = new ForUpdate();
			fu.setSearch(new BigDecimal(s));
			fu.setIncrease(new BigDecimal(i));
			
			if (ss.update("lhw.update", fu) >= 1) {
				request.setAttribute("r", "인상 성공");
				ss.commit();
			} else {
				request.setAttribute("r", "인상 실패");
			}
		} catch (Exception e) {
			request.setAttribute("r", "인상 실패");
		}
	}
	
	public static void search3(HttpServletRequest request, HttpServletResponse response) {
		try {
			String min = request.getParameter("min");
			String max = request.getParameter("max");
			
			MinMax mm = new MinMax();
			mm.setMin(new BigDecimal(min));
			mm.setMax(new BigDecimal(max));
			
			request.setAttribute("products", DBManager.connect().selectList("lhw.searchProduct3", mm));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void search2(HttpServletRequest request, HttpServletResponse response) {
		try {
			String p_price = request.getParameter("p_price");
			Product p = new Product();
			p.setP_price(new BigDecimal(p_price));
			
			request.setAttribute("products", DBManager.connect().selectList("lhw.searchProduct2", p));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void search(HttpServletRequest request, HttpServletResponse response) {
		try {
			String p_name = request.getParameter("p_name");
			Product p = new Product();
			p.setP_name(p_name);
			
			request.setAttribute("products", DBManager.connect().selectList("lhw.searchProduct", p));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("products", 
				DBManager.connect().selectList("lhw.getAllProduct")
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void reg(HttpServletRequest request, HttpServletResponse response) {
		try {
			SqlSession ss = DBManager.connect();

			String path = request.getServletContext().getRealPath("img");

			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "euc-kr",
					new DefaultFileRenamePolicy());

			String p_name = mr.getParameter("p_name");
			String p_price = mr.getParameter("p_price");
			String p_exp = mr.getParameter("p_exp");
			String p_img = mr.getFilesystemName("p_img");
			p_img = URLEncoder.encode(p_img, "euc-kr");
			p_img = p_img.replace("+", " ");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			// 자바빈객체
			Product p = new Product();
			p.setP_name(p_name);
			p.setP_img(p_img);
			p.setP_price(new BigDecimal(p_price));
			p.setP_exp(sdf.parse(p_exp));

			if (ss.insert("lhw.reg", p) == 1) {
				request.setAttribute("r", "등록 성공");
				ss.commit();
			} else {
				request.setAttribute("r", "등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "등록 실패");
		}
	}
}


