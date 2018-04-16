package com.lhw.smb2.item;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class ProductDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllItem(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("products", ss.getMapper(ProductMapper.class).getAllItem());
	}

	public void reg(Item i, HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/img");
			System.out.println(path);

			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "euc-kr",
					new DefaultFileRenamePolicy());

			String p_name = mr.getParameter("p_name");
			String p_price = mr.getParameter("p_price");
			String p_exp = mr.getParameter("p_exp");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
			String p_img = mr.getFilesystemName("p_img");
			p_img = URLEncoder.encode(p_img, "euc-kr");
			p_img = p_img.replace("+", " ");

			i.setP_name(p_name);
			i.setP_price(new BigDecimal(p_price));
			i.setP_exp(sdf.parse(p_exp));
			i.setP_img(p_img);
			
			if (ss.getMapper(ProductMapper.class).reg(i) == 1) {
				request.setAttribute("r", "성공");
			} else {
				request.setAttribute("r", "실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "실패");
		}

	}

	public void delete(Item i, HttpServletRequest request, HttpServletResponse response) {
		try {
			if(ss.getMapper(ProductMapper.class).delete(i)==1) {
				request.setAttribute("r", "아이템 삭제 성공");
			} else {
				request.setAttribute("r", "아이템 삭제 성공");
			}
		} catch (Exception e) {
			request.setAttribute("r", "DB오류");
			e.printStackTrace();
		}
	}
	
}
