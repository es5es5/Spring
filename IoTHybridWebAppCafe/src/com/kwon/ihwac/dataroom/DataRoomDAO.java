package com.kwon.ihwac.dataroom;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kwon.ihwac.main.DBManager;
import com.kwon.ihwac.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DataRoomDAO {
	private ArrayList<Data> datas;

	private static final DataRoomDAO DRDAO = new DataRoomDAO();

	private DataRoomDAO() {
		// TODO Auto-generated constructor stub
	}

	public static DataRoomDAO getDrdao() {
		return DRDAO;
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			int id_id = Integer.parseInt(request.getParameter("id_id"));
			String sql = "delete from ihwac_dataroom" + " where id_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id_id);

			if (pstmt.executeUpdate() == 1) {
				String path = request.getServletContext().getRealPath("etc");
				String id_file = request.getParameter("id_file");
				id_file = URLDecoder.decode(id_file, "euc-kr");
				File oldFile = new File(path + "/" + id_file);
				oldFile.delete();
				request.setAttribute("r", "파일 삭제 성공");
			} else {
				request.setAttribute("r", "파일 삭제 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "파일 삭제 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void getAllDatas(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String sql = "select * from ihwac_dataroom " + "order by id_title";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			datas = new ArrayList<>();
			Data d = null;
			while (rs.next()) {
				d = new Data();
				d.setId_id(rs.getInt("id_id"));
				d.setId_owner(rs.getString("id_owner"));
				d.setId_title(rs.getString("id_title"));
				d.setId_file(rs.getString("id_file"));
				d.setId_date(rs.getDate("id_date"));
				datas.add(d);
			}

			request.setAttribute("datas", datas);
		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB서버오류");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void reg(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String path = request.getServletContext().getRealPath("etc");
			
			MultipartRequest mr = new MultipartRequest(request, path, 104857600, "euc-kr",
					new DefaultFileRenamePolicy());
			Member m = (Member) request.getSession().getAttribute("loginMember");

			String id_title = mr.getParameter("id_title");
			String id_owner = m.getIm_id();

			String id_file = mr.getFilesystemName("id_file");
			id_file = URLEncoder.encode(id_file, "euc-kr");
			id_file = id_file.replace("+", " ");

			String sql = "insert into ihwac_dataroom " + "values(ihwac_dataroom_seq.nextval, ?, ?, ?, sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(2, id_title);
			pstmt.setString(1, id_owner);
			pstmt.setString(3, id_file);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "파일 업로드 성공");
			} else {
				request.setAttribute("r", "파일 업로드 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "파일 업로드 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}
