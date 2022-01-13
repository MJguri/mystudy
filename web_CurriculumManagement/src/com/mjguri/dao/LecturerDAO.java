package com.mjguri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mjguri.db.DBManager;
import com.mjguri.vo.CourseVO;
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
	
	public int selectMaxIdx() {
		int seqNum=0;
		
		//String sql = "SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'LEC_SEQ'";
		String sql = "SELECT MAX(IDX)+1 AS IDX FROM LECTURER_TBL";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				seqNum = rs.getInt(1);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return seqNum;
	}
	
	public void insertLecturer(LecturerVO lVo) {
		String sql = "INSERT INTO LECTURER_TBL VALUES(?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, lVo.getIdx());
			psmt.setString(2, lVo.getName());
			psmt.setString(3, lVo.getMajor());
			psmt.setString(4, lVo.getField());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	public LecturerVO selectLecturerByIdx(int idx) {
		LecturerVO lVo = null;
		
		String sql = "SELECT * FROM LECTURER_TBL WHERE IDX = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				lVo = new LecturerVO();
				lVo.setIdx(rs.getInt("idx"));
				lVo.setName(rs.getString("name"));
				lVo.setMajor(rs.getString("major"));
				lVo.setField(rs.getString("field"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return lVo;
	}
	
	public void updateLecturer(LecturerVO lVo) {
		String sql="UPDATE LECTURER_TBL SET NAME=?, MAJOR=?, FIELD=? WHERE IDX=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,lVo.getName());
			psmt.setString(2,lVo.getMajor());
			psmt.setString(3,lVo.getField());
			psmt.setInt(4,lVo.getIdx());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}
	
	public String selectLecturerNameByIdx(int idx) {
		String lecName = null;
		System.out.println("idx -> :" + idx);
		String sql = "SELECT B.NAME FROM COURSE_TBL A JOIN LECTURER_TBL B ON (A.LECTURER = B.IDX) WHERE A.ID=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				lecName = rs.getString("name");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return lecName;
	}

}
