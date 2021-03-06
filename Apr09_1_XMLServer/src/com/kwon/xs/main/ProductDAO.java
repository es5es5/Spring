package com.kwon.xs.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDAO {

	public static String searchProductByName(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			// 한글처리
			// GET(x)
			// ㅋ -> %2A
			// %2A -> ㅋ 를 톰캣이 알아서
			// POST
			String p_name = request.getParameter("p_name");

			String sql = "select * from apr09_product " + "where p_name like '%'||?||'%' " + "order by p_name";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_name);
			rs = pstmt.executeQuery();

			// 문자열 대량으로 붙일 때 사용
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<apr09_product>"); // <테이블명>
			while (rs.next()) {
				sb.append("<product>"); // <데이터>

				// <필드명>값</필드명>
				sb.append("<p_name>" + rs.getString("p_name") + "</p_name>");
				sb.append("<p_price>" + rs.getInt("p_price") + "</p_price>");

				sb.append("</product>"); // </데이터>
			}
			sb.append("</apr09_product>"); // </테이블명>

			return sb.toString();

			// select 결과를 ArrayList로
			// attribute or session에 ArrayList를 담아서
			// view로 포워딩

			// select 결과를 String으로
			// HTML문법 형식을 빌려서 = XML
			// JS문법 형식을 빌려서 = JSON
			// 그 String을 응답

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static String searchProduct(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			int p_price = Integer.parseInt(request.getParameter("p_price"));

			String sql = "select * from apr09_product " + "where p_price < ? " + "order by p_name";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_price);
			rs = pstmt.executeQuery();

			// 문자열 대량으로 붙일 때 사용
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<apr09_product>"); // <테이블명>
			while (rs.next()) {
				sb.append("<product>"); // <데이터>

				// <필드명>값</필드명>
				sb.append("<p_name>" + rs.getString("p_name") + "</p_name>");
				sb.append("<p_price>" + rs.getInt("p_price") + "</p_price>");

				sb.append("</product>"); // </데이터>
			}
			sb.append("</apr09_product>"); // </테이블명>

			return sb.toString();

			// select 결과를 ArrayList로
			// attribute or session에 ArrayList를 담아서
			// view로 포워딩

			// select 결과를 String으로
			// HTML문법 형식을 빌려서 = XML
			// JS문법 형식을 빌려서 = JSON
			// 그 String을 응답

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static String getProduct(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from apr09_product order by p_name";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 문자열 대량으로 붙일 때 사용
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<apr09_product>"); // <테이블명>
			while (rs.next()) {
				sb.append("<product>"); // <데이터>

				// <필드명>값</필드명>
				sb.append("<p_name>" + rs.getString("p_name") + "</p_name>");
				sb.append("<p_price>" + rs.getInt("p_price") + "</p_price>");

				sb.append("</product>"); // </데이터>
			}
			sb.append("</apr09_product>"); // </테이블명>

			return sb.toString();

			// select 결과를 ArrayList로
			// attribute or session에 ArrayList를 담아서
			// view로 포워딩

			// select 결과를 String으로
			// HTML문법 형식을 빌려서 = XML
			// JS문법 형식을 빌려서 = JSON
			// 그 String을 응답

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static String getProductJSON(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from apr09_product order by p_name";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 문자열 대량으로 붙일 때 사용
			StringBuffer sb = new StringBuffer();
			boolean isFirst = true;

			sb.append("["); // <테이블명>
			while (rs.next()) {
				if (isFirst) {
					isFirst = false;
				} else {
					sb.append(",");
				}
				
				sb.append("{"); // <데이터>

				// <필드명>값</필드명>
				// JSON -> "필드명":"값"
				sb.append("\"p_name\":\"" + rs.getString("p_name") + "\"");
				sb.append(",");
				sb.append("\"p_price\":\"" + rs.getInt("p_price") + "\"");

				sb.append("}"); // </데이터>
			}
			sb.append("]"); // </테이블명>

			return sb.toString();

			// select 결과를 ArrayList로
			// attribute or session에 ArrayList를 담아서
			// view로 포워딩

			// select 결과를 String으로
			// HTML문법 형식을 빌려서 = XML
			// JS문법 형식을 빌려서 = JSON(Java Script Object Notation
			// 배열 : [1,2,3]
			// 객체 : {속성:값, 속성:값}
			// 그 String을 응답

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
}
