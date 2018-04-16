package com.kwon.ihwac.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kwon.ihwac.main.DBManager;
import com.kwon.ihwac.member.Member;

public class CommunityDAO {
	private ArrayList<Member> members;

	private static final CommunityDAO CDAO = new CommunityDAO();

	private CommunityDAO() {
		// TODO Auto-generated constructor stub
	}

	public static CommunityDAO getCdao() {
		return CDAO;
	}

	public void getAllMembers(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * " + "from ihwac_member " + "order by im_id";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			members = new ArrayList<>();
			Member m = null;
			while (rs.next()) {
				m = new Member();
				m.setIm_id(rs.getString("im_id"));
				m.setIm_name(rs.getString("im_name"));
				m.setIm_birthday(rs.getDate("im_birthday"));
				m.setIm_addr(rs.getString("im_addr"));
				m.setIm_img(rs.getString("im_img"));
				members.add(m);
			}

			if (members.size() == 0) {
				request.setAttribute("r", "없음");
				members.add(null);
			}
			request.setAttribute("members", members);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB서버오류");

			members = new ArrayList<>();
			members.add(null);
			request.setAttribute("members", members);
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public void getAllMsgs(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			HttpSession hs = request.getSession();
			Member m = (Member) hs.getAttribute("loginMember");
			String im_to = m.getIm_id();
			
			String sql = "select * from ihwac_msg " 
			+ "where im_to=? "
			+ "order by im_date desc";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, im_to);
			rs = pstmt.executeQuery();

			ArrayList<Msg> msgs = new ArrayList<>();
			Msg msg = null;
			while (rs.next()) {
				msg = new Msg();
				msg.setIm_no(rs.getInt("im_no"));
				msg.setIm_from(rs.getString("im_from"));
				msg.setIm_to(im_to);
				msg.setIm_txt(rs.getString("im_txt"));
				msg.setIm_date(rs.getDate("im_date"));
				msgs.add(msg);
			}

			request.setAttribute("msgs", msgs);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB서버오류");

			ArrayList<Msg> msgs = new ArrayList<>();
			
			request.setAttribute("msgs", msgs);
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public void sendMsg(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String im_to = request.getParameter("im_to");
			String im_txt = request.getParameter("im_txt");
			im_txt = im_txt.replace(" ", "&nbsp;");

			HttpSession hs = request.getSession();
			Member m = (Member) hs.getAttribute("loginMember");
			String im_from = m.getIm_id();

			String sql = "insert into ihwac_msg values(" 
			+ "ihwac_msg_seq.nextval, ?, ?, ?, sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, im_from);
			pstmt.setString(2, im_to);
			pstmt.setString(3, im_txt);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "쪽지 보내기 성공");
			} else {
				request.setAttribute("r", "쪽지 보내기 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "쪽지 보내기 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	public void deleteMsg(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int im_no = Integer.parseInt(request.getParameter("im_no"));
			
			String sql = "delete from ihwac_msg where im_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, im_no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "쪽지 삭제 성공");
			} else {
				request.setAttribute("r", "쪽지 삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "쪽지 삭제 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}
