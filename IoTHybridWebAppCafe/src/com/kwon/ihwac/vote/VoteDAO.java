package com.kwon.ihwac.vote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.ihwac.main.DBManager;
import com.kwon.ihwac.member.Member;

public class VoteDAO {
	private static final VoteDAO VDAO = new VoteDAO();

	public static VoteDAO getVdao() {
		return VDAO;
	}

	private VoteDAO() {
		// TODO Auto-generated constructor stub
	}

	public void doVote(HttpServletRequest request, HttpServletResponse response) {
		if (vote(request, response)) {
			updateVoteCount(request, response);
			updateVoteItemCount(request, response);
			request.setAttribute("r", "투표 성공");
		} else {
			request.setAttribute("r", "투표 실패");
		}
	}

	public void getVote(HttpServletRequest request, HttpServletResponse response) {
		getVoteTitle(request, response);
		getVoteItem(request, response);
	}

	private void getVoteItem(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from ihwac_vote_item order by ivi_no";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<VoteItem> items = new ArrayList<>();
			VoteItem vi = null;
			while (rs.next()) {
				vi = new VoteItem();
				vi.setIvi_no(rs.getInt("ivi_no"));
				vi.setIvi_item(rs.getString("ivi_item"));
				vi.setIvi_count(rs.getInt("ivi_count"));
				vi.setIvi_percent(rs.getDouble("ivi_percent"));
				items.add(vi);
			}
			request.setAttribute("ivi_items", items);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB서버오류");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	private void getVoteTitle(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from ihwac_vote";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.next();
			String iv_title = rs.getString("iv_title");
			int iv_count = rs.getInt("iv_count");
			String iv_owner = rs.getString("iv_owner");

			request.setAttribute("iv_title", iv_title);
			request.setAttribute("iv_count", iv_count);
			request.setAttribute("iv_owner", iv_owner);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB서버오류");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	private boolean regItem(String[] items) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String sql = "delete from ihwac_vote_item";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();

			sql = "delete from ihwac_vote_vote";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();

			for (int i = 0; i < items.length; i++) {
				sql = "insert into ihwac_vote_item values(" + "?, ?, 0, 0)";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, i);
				pstmt.setString(2, items[i]);
				pstmt.executeUpdate();
				pstmt.close();
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void regVote(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			Member m = (Member) request.getSession().getAttribute("loginMember");
			String iv_owner = m.getIm_id();
			String iv_title = request.getParameter("iv_title");

			String iv_items = request.getParameter("iv_items");
			String[] iv_items2 = iv_items.split("\r\n");

			String sql = "update ihwac_vote " + "set iv_title=?, iv_owner=?, iv_count=0";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, iv_title);
			pstmt.setString(2, iv_owner);

			if (pstmt.executeUpdate() == 1) {
				if (regItem(iv_items2)) {
					request.setAttribute("r", "투표 등록 성공");
				} else {
					request.setAttribute("r", "투표 등록 실패");
				}
			} else {
				request.setAttribute("r", "투표 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "투표 등록 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	private void updateVoteCount(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String sql = "update ihwac_vote set iv_count = iv_count + 1";

			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	private void updateVoteItemCount(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int ivv_ivi_no = Integer.parseInt(request.getParameter("ivv_ivi_no"));

			String sql = "update ihwac_vote_item " + "set ivi_count = ivi_count + 1, "
					+ "ivi_percent = (ivi_count+1) / (select iv_count from ihwac_vote) " + "where ivi_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ivv_ivi_no);
			pstmt.executeUpdate();
			pstmt.close();

			sql = "update ihwac_vote_item " + "set ivi_percent = ivi_count / (select iv_count from ihwac_vote)";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	private boolean vote(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			Member m = (Member) request.getSession().getAttribute("loginMember");
			String ivv_im_id = m.getIm_id();

			int ivv_ivi_no = Integer.parseInt(request.getParameter("ivv_ivi_no"));

			String sql = "insert into ihwac_vote_vote values(?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ivv_im_id);
			pstmt.setInt(2, ivv_ivi_no);

			return (pstmt.executeUpdate() == 1);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}
