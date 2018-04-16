package com.kwon.ihwac.sns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kwon.ihwac.main.DBManager;
import com.kwon.ihwac.member.Member;

public class SNSDAO {
	private static final SNSDAO SDAO = new SNSDAO();

	public static SNSDAO getSdao() {
		return SDAO;
	}

	private ArrayList<SNSMsg> msgs;

	private SNSDAO() {
		// TODO Auto-generated constructor stub
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int is_no = Integer.parseInt(request.getParameter("is_no"));

			String sql = "delete from ihwac_sns " + "where is_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, is_no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "글 삭제 성공");
			} else {
				request.setAttribute("r", "글 삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "글 삭제 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void deleteRepl(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int isr_no = Integer.parseInt(request.getParameter("isr_no"));

			String sql = "delete from ihwac_sns_repl " + "where isr_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, isr_no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "리플 삭제 성공");
			} else {
				request.setAttribute("r", "리플 삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "리플 삭제 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void deleteRepl2(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int is_no = Integer.parseInt(request.getParameter("is_no"));

			String sql = "delete from ihwac_sns_repl " 
						+ "where isr_is_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, is_no);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void getAllMsgs(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * " + "from ihwac_sns, ihwac_member " + "where is_owner = im_id " + "order by is_date";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			msgs = new ArrayList<>();
			SNSMsg s = null;
			while (rs.next()) {
				s = new SNSMsg();
				s.setIs_no(rs.getInt("is_no"));
				s.setIs_owner(rs.getString("is_owner"));
				s.setIs_txt(rs.getString("is_txt"));
				s.setIs_date(rs.getDate("is_date"));
				s.setIm_img(rs.getString("im_img"));
				s.setIs_repls(getRepls(s.getIs_no()));
				msgs.add(s);
			}

			if (msgs.size() == 0) {
				request.setAttribute("r", "없음");
				msgs.add(null);
				msgs.add(null);
				msgs.add(null);
				msgs.add(null);
				msgs.add(null);
			}

			HttpSession hs = request.getSession();
			hs.setAttribute("searchSNS", null);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB서버오류");

			msgs = new ArrayList<>();
			msgs.add(null);
			msgs.add(null);
			msgs.add(null);
			msgs.add(null);
			msgs.add(null);

			HttpSession hs = request.getSession();
			hs.setAttribute("searchSNS", null);

		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	// 글 번호를 넣으면 리플들을 조회해 줄 메소드
	private ArrayList<SNSRepl> getRepls(int is_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from ihwac_sns_repl " + "where isr_is_no=? " + "order by isr_date";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, is_no);
			rs = pstmt.executeQuery();

			ArrayList<SNSRepl> repls = new ArrayList<>();
			SNSRepl s = null;
			while (rs.next()) {
				s = new SNSRepl();
				s.setIsr_no(rs.getInt("isr_no"));
				s.setIsr_is_no(is_no);
				s.setIsr_owner(rs.getString("isr_owner"));
				s.setIsr_txt(rs.getString("isr_txt"));
				s.setIsr_date(rs.getDate("isr_date"));
				repls.add(s);
			}
			return repls;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void paging(int page, HttpServletRequest request, HttpServletResponse response) {
		HttpSession hs = request.getSession();

		@SuppressWarnings("unchecked")
		ArrayList<SNSMsg> msgs2 = (ArrayList<SNSMsg>) hs.getAttribute("searchSNS");

		if (msgs2 == null) {
			msgs2 = msgs;
		}

		double cnt = 10;
		int itemSize = msgs2.size();
		int pageCount = (int) Math.ceil(itemSize / cnt);
		request.setAttribute("pageCount", pageCount);

		int start = itemSize - ((int) cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - ((int) cnt + 1);

		ArrayList<SNSMsg> items2 = new ArrayList<>();

		for (int i = start - 1; i > end; i--) {
			items2.add(msgs2.get(i));
		}

		request.setAttribute("curPageNo", page);
		request.setAttribute("msgs", items2);
	}

	public void searchMsgs(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String is_owner = request.getParameter("is_owner");

			String sql = "select * " + "from ihwac_sns, ihwac_member " + "where is_owner = im_id and is_owner=?"
					+ "order by is_date";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, is_owner);
			rs = pstmt.executeQuery();

			ArrayList<SNSMsg> msgs = new ArrayList<>();
			SNSMsg s = null;
			while (rs.next()) {
				s = new SNSMsg();
				s.setIs_no(rs.getInt("is_no"));
				s.setIs_owner(rs.getString("is_owner"));
				s.setIs_txt(rs.getString("is_txt"));
				s.setIs_date(rs.getDate("is_date"));
				s.setIm_img(rs.getString("im_img"));
				s.setIs_repls(getRepls(s.getIs_no()));
				msgs.add(s);
			}

			if (msgs.size() == 0) {
				request.setAttribute("r", "없음");
				msgs.add(null);
				msgs.add(null);
				msgs.add(null);
				msgs.add(null);
				msgs.add(null);
			}

			HttpSession hs = request.getSession();
			hs.setAttribute("searchSNS", msgs);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB서버오류");

			ArrayList<SNSMsg> msgs = new ArrayList<>();
			msgs.add(null);
			msgs.add(null);
			msgs.add(null);
			msgs.add(null);
			msgs.add(null);

			HttpSession hs = request.getSession();
			hs.setAttribute("searchSNS", msgs);

		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void searchMsgsByTxt(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			request.setCharacterEncoding("euc-kr");
			String is_txt = request.getParameter("is_txt");

			String sql = "select * " + "from ihwac_sns, ihwac_member "
					+ "where is_owner = im_id and is_txt like '%'||?||'%' " + "order by is_date";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, is_txt);
			rs = pstmt.executeQuery();

			ArrayList<SNSMsg> msgs = new ArrayList<>();
			SNSMsg s = null;
			while (rs.next()) {
				s = new SNSMsg();
				s.setIs_no(rs.getInt("is_no"));
				s.setIs_owner(rs.getString("is_owner"));
				s.setIs_txt(rs.getString("is_txt"));
				s.setIs_date(rs.getDate("is_date"));
				s.setIm_img(rs.getString("im_img"));
				s.setIs_repls(getRepls(s.getIs_no()));
				msgs.add(s);
			}

			if (msgs.size() == 0) {
				request.setAttribute("r", "없음");
				msgs.add(null);
				msgs.add(null);
				msgs.add(null);
				msgs.add(null);
				msgs.add(null);
			}

			HttpSession hs = request.getSession();
			hs.setAttribute("searchSNS", msgs);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB서버오류");

			ArrayList<SNSMsg> msgs = new ArrayList<>();
			msgs.add(null);
			msgs.add(null);
			msgs.add(null);
			msgs.add(null);
			msgs.add(null);

			HttpSession hs = request.getSession();
			hs.setAttribute("searchSNS", msgs);

		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void update(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String is_txt = request.getParameter("is_txt");
			is_txt = is_txt.replace("\n", "<br>");
			is_txt = is_txt.replace(" ", "&nbsp;");

			int is_no = Integer.parseInt(request.getParameter("is_no"));

			String sql = "update ihwac_sns " + "set is_txt=?, is_date=sysdate " + "where is_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, is_txt);
			pstmt.setInt(2, is_no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "글 수정 성공");
			} else {
				request.setAttribute("r", "글 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "글 수정 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void write(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String is_txt = request.getParameter("is_txt");
			is_txt = is_txt.replace("\n", "<br>");
			is_txt = is_txt.replace(" ", "&nbsp;");

			HttpSession hs = request.getSession();
			Member m = (Member) hs.getAttribute("loginMember");
			String is_owner = m.getIm_id();

			String sql = "insert into ihwac_sns values(" + "ihwac_sns_seq.nextval, ?, ?, sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, is_owner);
			pstmt.setString(2, is_txt);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "글쓰기 성공");
			} else {
				request.setAttribute("r", "글쓰기 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "글쓰기 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void writeRepl(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int isr_is_no = Integer.parseInt(request.getParameter("isr_is_no"));

			String isr_txt = request.getParameter("isr_txt");
			isr_txt = isr_txt.replace(" ", "&nbsp;");

			HttpSession hs = request.getSession();
			Member m = (Member) hs.getAttribute("loginMember");
			String isr_owner = m.getIm_id();

			String sql = "insert into ihwac_sns_repl values(" + "ihwac_sns_repl_seq.nextval, ?, ?, ?, sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, isr_is_no);
			pstmt.setString(2, isr_owner);
			pstmt.setString(3, isr_txt);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "리플 쓰기 성공");
			} else {
				request.setAttribute("r", "리플 쓰기 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "리플 쓰기 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

}
