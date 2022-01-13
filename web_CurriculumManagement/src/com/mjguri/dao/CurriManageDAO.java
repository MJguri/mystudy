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

public class CurriManageDAO {
	
	private CurriManageDAO () {}
	private static CurriManageDAO dao = new CurriManageDAO();
	public static CurriManageDAO getInstance() {
		return dao;
	}
	
	// CurriculumList 조회 
	public List<CurriculumListVO> selectCurriculumList(){
		List<CurriculumListVO> list = new ArrayList<>();
		
		String[] yoil = {"월", "화", "수", "목", "금", "토"};
		
		// ID 기준 내림차순 정렬 
		String sql = "SELECT A.ID, A.NAME, A.CREDIT, B.NAME AS LECTURER, A.WEEK FROM COURSE_TBL A JOIN LECTURER_TBL B ON (A.LECTURER = B.IDX) ORDER BY ID DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CurriculumListVO clVO = new CurriculumListVO();
				
				clVO.setId(rs.getString("id"));
				clVO.setName(rs.getString("name"));
				clVO.setCredit(rs.getInt("credit"));
				clVO.setLecturer(rs.getString("lecturer"));
				//clVO.setWeek(rs.getInt("week"));
				clVO.setWeekKR(yoil[rs.getInt("week")-1]); 
				
				
				list.add(clVO);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	// CurriculumList totalCount
	public int selectTotalCntCurriculumList() {
		int cntAll=0;
		
		String sql = "SELECT COUNT(*) FROM COURSE_TBL A JOIN LECTURER_TBL B ON (A.LECTURER = B.IDX)";
		
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
	
	public List<LecturerVO> selectLecturerList(){
		List<LecturerVO> lecturerList = new ArrayList<>();
		
		String sql = "SELECT IDX, NAME FROM LECTURER_TBL";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				LecturerVO lVo = new LecturerVO();
				lVo.setName(rs.getString("name"));
				lVo.setIdx(rs.getInt("idx"));
				
				lecturerList.add(lVo);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return lecturerList;
	}
	
	public void insertCurriculum(CourseVO cVo) {
		String sql = "INSERT INTO COURSE_TBL VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getCredit());
			psmt.setInt(4, cVo.getLecturer());
			psmt.setInt(5, cVo.getWeek());
			psmt.setInt(6, cVo.getStarthour());
			psmt.setInt(7, cVo.getEndhour());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}
	
	public CourseVO selectBoardById(String id) {
		CourseVO cVo = null;
		String[] yoil = {"월", "화", "수", "목", "금", "토"};
		
		String sql = "SELECT * FROM COURSE_TBL WHERE id= ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				cVo = new CourseVO();
				cVo.setId(rs.getString("id"));
				cVo.setName(rs.getString("name"));
				cVo.setCredit(rs.getInt("credit"));
				cVo.setLecturer(rs.getInt("lecturer"));
				cVo.setWeek(rs.getInt("week"));
				cVo.setWeekKR((yoil[rs.getInt("week")-1])); 
				cVo.setStarthour(rs.getInt("start_hour"));
				cVo.setEndhour(rs.getInt("end_hour"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return cVo; 
	}
	
	public void deleteCourseById(String id) {
		String sql = "DELETE FROM COURSE_TBL WHERE id=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}
	
	public void updateCurriculum(CourseVO cVo, String originId) {
		String sql="UPDATE COURSE_TBL SET ID=?, NAME=?, CREDIT=?, LECTURER=?, WEEK=?, START_HOUR=?, END_HOUR=? WHERE ID=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,cVo.getId());
			psmt.setString(2,cVo.getName());
			psmt.setInt(3,cVo.getCredit());
			psmt.setInt(4,cVo.getLecturer());
			psmt.setInt(5,cVo.getWeek());
			psmt.setInt(6,cVo.getStarthour());
			psmt.setInt(7,cVo.getEndhour());
			psmt.setString(8, originId);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	public List<String> selectCurriNameById(int id) {
		List<String> cList = new ArrayList<>();
		
		String sql = "SELECT NAME FROM COURSE_TBL WHERE LECTURER = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				cList.add(rs.getString("name"));
			}
			
			if(cList.size()==0) {
				cList.add("없음");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		return cList;
	}
	
	

}
