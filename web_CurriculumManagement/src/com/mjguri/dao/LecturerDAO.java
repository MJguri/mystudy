package com.mjguri.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mjguri.db.DBManager;
import com.mjguri.vo.CurriculumListVO;
import com.mjguri.vo.LecturerVO;

public class LecturerDAO {
	private LecturerDAO() {}
	private static LecturerDAO dao = new LecturerDAO();
	public static LecturerDAO getInstance() {
		return dao;
	}
	
	public List<LecturerVO> selectLecturerList(){
		List<LecturerVO> list = new ArrayList<>();
		
		// ID 기준 내림차순 정렬 
		String sql = "SELECT IDX, NAME, MAJOR FROM LECTURER_TBL ORDER BY IDX DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				LecturerVO lVO = new LecturerVO();
				
				lVO.setIdx(rs.getInt("idx"));
				lVO.setName(rs.getString("name"));
				lVO.setMajor(rs.getString("major"));
				
				list.add(lVO);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public int selectTotalCntLecturerList() {
		int cntAll=0;
		
		String sql = "SELECT COUNT(*) FROM LECTURER_TBL";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				cntAll = rs.getInt(1);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return cntAll;
	}

}
