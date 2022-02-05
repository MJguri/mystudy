package mj.guri.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mj.guri.vo.MemberRegiVO;
import mj.guri.vo.MemberVO;

public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	private int memberNum;
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	
	private RowMapper<MemberVO> rowMapper = new RowMapper<MemberVO>() {
		
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException{
			MemberVO mVo = new MemberVO(
					rs.getInt("memberNum"),
					rs.getString("memberId"),
					rs.getString("memberPassword"),
					rs.getString("memberName"),
					rs.getString("memberEmail"),
					rs.getString("memberPhone"));

			return mVo;
		}
	};
	
	//members테이블 정보 조회
	public List<MemberVO> selectAll() {
		String sql = "SELECT * FROM MEMBERS";
		
		List<MemberVO> list = jdbcTemplate.query(sql, rowMapper);
		
		return list;
	}
	
	// id로 정보조회하기 
	public MemberVO selectById(String memberId) {
		String sql = "SELECT * FROM members WHERE memberId=?"; 

		List<MemberVO> result = jdbcTemplate.query(sql,rowMapper,memberId);
		
		return result.isEmpty()?null:result.get(0);
	}
	
	public MemberVO selectByNum(Long memberNum) {
		String sql = "SELECT * FROM MEMBERS WHERE MEMBERNUM=?";
		
		List<MemberVO> result = jdbcTemplate.query(sql, rowMapper, memberNum);
		
		return result.isEmpty()?null:result.get(0);
	}
	
	// 회원 가입하기
	public void insertMember(MemberRegiVO reg) {
		String sql = "INSERT INTO members VALUES(MEMBERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql,
				reg.getMemberId(),
				reg.getMemberPassword(),
				reg.getMemberName(),
				reg.getMemberEmail(),
				reg.getMemberPhone());
	}
	
	//회원 정보 수정하기
	public void updateMember(MemberVO mVo) {
		String sql = "UPDATE MEMBERS SET MEMBERID= ?, MEMBERNAME= ?, MEMBEREMAIL= ?, MEMBERPHONE= ? WHERE MEMBERNUM = ?";
		jdbcTemplate.update(sql, 
				mVo.getMemberId(),
				mVo.getMemberName(),
				mVo.getMemberEmail(),
				mVo.getMemberPhone(),
				mVo.getMemberNum());
	}

	//조인 테이블 삭제하는법 봐야함
	public void deleteMember(Long memberNum2) {
		//String sql = "DELETE"
		
	}

}
