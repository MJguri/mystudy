package mj.guri.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mj.guri.vo.QnaDetailVO;

public class QnaDetailDAO {
	private JdbcTemplate jdbcTemplate;

	// 생성자를 통한 주입
	public QnaDetailDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	// 공통의 RowMapper 를 꺼내 봅시다.
	private RowMapper<QnaDetailVO> rowMapper =
			new RowMapper<QnaDetailVO>() {
					@Override
					public QnaDetailVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						QnaDetailVO qdVo = new QnaDetailVO(
								rs.getString("qnaBoardTitle"),
								rs.getTimestamp("qnaBoardRegdate"),
								rs.getString("memberName"),
								rs.getInt("qnaBoardCount"),
								rs.getString("qnaBoardContent"),
								rs.getString("commentContent"),
								rs.getTimestamp("commentRegdate"));
					
						return qdVo;
					}
			};
			
	public QnaDetailVO selectQnaDetail(Long qnaBoardNum) {
		String sql = "SELECT A.QNABOARDTITLE, A.QNABOARDREGDATE, B.MEMBERNAME, A.QNABOARDCOUNT, A.QNABOARDCONTENT, C.COMMENTCONTENT, C.COMMENTREGDATE FROM BOARDS A JOIN MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM) LEFT OUTER JOIN COMMENTS C ON (A.QNABOARDNUM = C.QNABOARDNUM) WHERE A.QNABOARDNUM = ?";
		List<QnaDetailVO> list = jdbcTemplate.query(sql, rowMapper, qnaBoardNum);
		
		return list.get(0);
	}
			
}
