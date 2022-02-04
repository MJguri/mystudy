package mj.guri.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mj.guri.vo.QnaRegiVO;
import mj.guri.vo.QnaVO;


public class QnaDAO {
	private JdbcTemplate jdbcTemplate;

	// 생성자를 통한 주입
	public QnaDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	// 공통의 RowMapper 를 꺼내 봅시다.
	private RowMapper<QnaVO> rowMapper =
			new RowMapper<QnaVO>() {
					@Override
					public QnaVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						QnaVO blVo = new QnaVO(
								rs.getInt("qnaBoardNum"),
								rs.getString("qnaBoardTitle"),
								rs.getString("memberName"),
								rs.getTimestamp("qnaBoardRegdate"),
								rs.getInt("qnaBoardCount"));
					
						return blVo;
					}
			};
	
	public List<QnaVO> selectQnaList(){
		String sql = "SELECT A.QNABOARDNUM, A.QNABOARDTITLE, B.MEMBERNAME, A.QNABOARDREGDATE, A.QNABOARDCOUNT FROM BOARDS A JOIN  MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM) ORDER BY A.QNABOARDNUM DESC"; 				  
		List<QnaVO> result = jdbcTemplate.query(sql,rowMapper);
		return result;
	}
	
	//전체 게시글 수
	public int selectAllNumBoard() {
		
		String sql = "SELECT COUNT(*) FROM BOARDS A JOIN  MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM)";
		Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return cnt;
	}
	
	//페이징 SELECT 쿼리 
	public List<QnaVO> selectTargetBoard(int section, int pageNum){
		
		String sql = "SELECT * FROM (SELECT ROWNUM AS RN, QNABOARDNUM, QNABOARDTITLE, MEMBERNAME, QNABOARDREGDATE, QNABOARDCOUNT FROM (SELECT A.QNABOARDNUM, A.QNABOARDTITLE, B.MEMBERNAME, A.QNABOARDREGDATE, A.QNABOARDCOUNT FROM BOARDS A JOIN MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM) ORDER BY A.QNABOARDNUM DESC)) WHERE RN BETWEEN (?-1)*100 + (?-1)*10 +1 and (?-1)*100 + (?) * 10";
		
		List<QnaVO> list = jdbcTemplate.query(sql, rowMapper, section, pageNum, section, pageNum);
			
		return list;
	}
	
	public void insertQna(QnaRegiVO qVo, int memberNum) {
		String sql = "INSERT INTO boards VALUES(BOARDS_SEQ.NEXTVAL, ?, ?, ?,SYSDATE, DEFAULT)";
		
		jdbcTemplate.update(sql, memberNum, qVo.getQnaBoardTitle(), qVo.getQnaBoardContent());
	}
	
	public void delQna(Long qnaBoardNum) {
		String sql = "DELETE FROM BOARDS WHERE QNABOARDNUM = ?";
		jdbcTemplate.update(sql, qnaBoardNum);
	}
	
	public void updateQna(Long qnaBoardNum, QnaRegiVO qVo) {
		String sql = "UPDATE BOARDS SET QNABOARDTITLE = ? , QNABOARDCONTENT = ? WHERE QNABOARDNUM = ?";
		jdbcTemplate.update(sql, qVo.getQnaBoardTitle(), qVo.getQnaBoardContent(), qnaBoardNum);
	}
			

}
