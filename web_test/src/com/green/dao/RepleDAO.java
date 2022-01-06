package com.green.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBConnect;
import com.green.vo.RepleVO;


public class RepleDAO {
	private RepleDAO() {}
	
	private static RepleDAO dao = new RepleDAO();
	public static RepleDAO getInstance() {
		return dao;
	}
	
public void insertReple(String c_user, String c_password, String c_comment) {
	
		System.out.println("인서트 시작");
		
		String sql = "INSERT INTO REPLE_TBL VALUES ( REPLE_SEQ.NEXTVAL, 1, ?, ?, ?, SYSDATE)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, c_user);
			psmt.setString(2, c_comment);
			psmt.setString(3, c_password);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn,psmt);
		}
		
	}

	//----------------------------------------------
	public List<RepleVO> selectAllText(){
		List<RepleVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM REPLE_TBL ORDER BY C_CODE DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnect.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				RepleVO rVo = new RepleVO();
				rVo.setC_code(rs.getInt("C_code"));
				rVo.setB_code(rs.getInt("B_code"));
				rVo.setC_user(rs.getString("C_user"));
				rVo.setC_comment(rs.getString("C_comment"));
				rVo.setC_password(rs.getString("C_password"));
				rVo.setC_regdate(rs.getTimestamp("C_regDate"));
				
				list.add(rVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn, stmt, rs);
		}
		return list;
	}
	
	public String selectPwdByCode(int C_code) {
		String password = null;
		String sql = "SELECT C_password FROM REPLE_TBL WHERE C_code =?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null; 
		
		System.out.println("암호 셀렉트 시작");
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, C_code);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				password = rs.getString("C_password");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn, psmt, rs);
		}
		return password;
	}
	
	public void updateReple(String C_comment,int C_code) {
		String sql = "UPDATE REPLE_TBL SET C_comment = ? WHERE C_code = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, C_comment);
			psmt.setInt(2, C_code);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn,psmt);
		}
	}
	
	public void deleteReple(int C_code) {
		String sql = "DELETE FROM REPLE_TBL WHERE C_code = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, C_code);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn,psmt);
		}
	}
	
	
}
