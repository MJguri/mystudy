package mj.guri.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mj.guri.vo.AdminQnaVO;
import mj.guri.vo.InsertComVO;
import mj.guri.vo.QnaRegiVO;
import mj.guri.vo.QnaUpdateVO;
import mj.guri.vo.QnaVO;


public class QnaDAO {
	
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
//	private JdbcTemplate jdbcTemplate;
//
//	// 생성자를 통한 주입
//	public QnaDAO(DataSource ds) {
//		this.jdbcTemplate = new JdbcTemplate(ds);
//	}
//
//	// 공통의 RowMapper 를 꺼내 봅시다.
//	private RowMapper<QnaVO> rowMapper =
//			new RowMapper<QnaVO>() {
//					@Override
//					public QnaVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//						QnaVO blVo = new QnaVO(
//								rs.getInt("qnaBoardNum"),
//								rs.getString("qnaBoardTitle"),
//								rs.getString("memberName"),
//								rs.getTimestamp("qnaBoardRegdate"),
//								rs.getInt("qnaBoardCount"));
//					
//						return blVo;
//					}
//			};
//	
//	// 공통의 RowMapper 를 꺼내 봅시다.
//	private RowMapper<AdminQnaVO> _rowMapper =
//			new RowMapper<AdminQnaVO>() {
//					@Override
//					public AdminQnaVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//						AdminQnaVO aqVo = new AdminQnaVO(
//								rs.getInt("qnaBoardNum"),
//								rs.getString("qnaBoardTitle"),
//								rs.getString("memberName"),
//								rs.getTimestamp("qnaBoardRegdate"),
//								rs.getInt("qnaBoardCount"),
//								rs.getString("commentYn"));
//					
//						return aqVo;
//					}
//			};
	public List<QnaVO> selectQnaList(){
		//String sql = "SELECT A.QNABOARDNUM, A.QNABOARDTITLE, B.MEMBERNAME, A.QNABOARDREGDATE, A.QNABOARDCOUNT FROM BOARDS A JOIN  MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM) ORDER BY A.QNABOARDNUM DESC"; 				  
		List<QnaVO> result = sqlSession.selectList("mybatis.mapper.qna.selectQnaList");
		return result;
	}
	
	//전체 게시글 수
	public int selectAllNumBoard() {
		//String sql = "SELECT COUNT(*) FROM BOARDS A JOIN  MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM)";
		return sqlSession.selectOne("mybatis.mapper.qna.selectAllNumBoard");
	}
	
	//페이징 SELECT 쿼리 
	public List<QnaVO> selectTargetBoard(int section, int pageNum){
		
		//String sql = "SELECT * FROM (SELECT ROWNUM AS RN, QNABOARDNUM, QNABOARDTITLE, MEMBERNAME, QNABOARDREGDATE, QNABOARDCOUNT FROM (SELECT A.QNABOARDNUM, A.QNABOARDTITLE, B.MEMBERNAME, A.QNABOARDREGDATE, A.QNABOARDCOUNT FROM BOARDS A JOIN MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM) ORDER BY A.QNABOARDNUM DESC)) WHERE RN BETWEEN (?-1)*100 + (?-1)*10 +1 and (?-1)*100 + (?) * 10";

		Map<String, Integer> map = new HashMap<>();
		map.put("section", section);
		map.put("pageNum", pageNum);
		
		List<QnaVO> list = sqlSession.selectList("mybatis.mapper.qna.selectTargetBoard", map);
			
		return list;
	}
	
	public void insertQna(QnaRegiVO qVo, int memberNum) {
		qVo.setMemberNum(memberNum);
		//String sql = "INSERT INTO boards VALUES(BOARDS_SEQ.NEXTVAL, ?, ?, ?,SYSDATE, DEFAULT)";
		
		//jdbcTemplate.update(sql, memberNum, qVo.getQnaBoardTitle(), qVo.getQnaBoardContent());
		sqlSession.insert("mybatis.mapper.qna.insertQna", qVo);
	}
	
	public void delQna(Long qnaBoardNum) {
		//String sql = "DELETE FROM BOARDS WHERE QNABOARDNUM = ?";
		sqlSession.delete("mybatis.mapper.qna.delQna",qnaBoardNum);
		//jdbcTemplate.update(sql, qnaBoardNum);
	}
	
	public void updateQna(Long qnaBoardNum, QnaUpdateVO qVo) {
		qVo.setQnaBoardNum(qnaBoardNum);
		//String sql = "UPDATE BOARDS SET QNABOARDTITLE = ? , QNABOARDCONTENT = ? WHERE QNABOARDNUM = ?";
		//jdbcTemplate.update(sql, qVo.getQnaBoardTitle(), qVo.getQnaBoardContent(), qnaBoardNum);
		sqlSession.update("mybatis.mapper.qna.updateQna", qVo);
	}
	
	public List<AdminQnaVO> selectAdminTargetBoard(int section, int pageNum){
		//String sql="SELECT * FROM (SELECT ROWNUM AS RN, QNABOARDNUM, QNABOARDTITLE, MEMBERNAME, QNABOARDREGDATE, QNABOARDCOUNT, COMMENTYN FROM (SELECT A.QNABOARDNUM, A.QNABOARDTITLE, B.MEMBERNAME, A.QNABOARDREGDATE, A.QNABOARDCOUNT, CASE WHEN C.QNABOARDNUM IS NULL THEN 'N' ELSE 'Y' END COMMENTYN FROM BOARDS A JOIN MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM) LEFT OUTER JOIN COMMENTS C ON(A.QNABOARDNUM= C.QNABOARDNUM) ORDER BY A.QNABOARDNUM DESC)) WHERE RN BETWEEN (?-1)*100 + (?-1)*10 +1 and (?-1)*100 + (?) * 10";
		
		Map<String, Integer> map = new HashMap<>();
		map.put("section", section);
		map.put("pageNum", pageNum);
		
		List<AdminQnaVO> list = sqlSession.selectList("mybatis.mapper.qna.selectAdminTargetBoard", map);
		
		return list;
	}
	
	public void insertComments(Long qnaBoardNum, String comments) {
		//String sql="INSERT INTO comments VALUES(comments_seq.NEXTVAL, ?, ?, SYSDATE)";
		InsertComVO icVO = new InsertComVO();
		
		icVO.setComments(comments);
		icVO.setQnaBoardNum(qnaBoardNum);
		
		sqlSession.insert("mybatis.mapper.qna.insertComments", icVO);
	}
	
//	public List<QnaVO> selectQnaList(){
//		String sql = "SELECT A.QNABOARDNUM, A.QNABOARDTITLE, B.MEMBERNAME, A.QNABOARDREGDATE, A.QNABOARDCOUNT FROM BOARDS A JOIN  MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM) ORDER BY A.QNABOARDNUM DESC"; 				  
//		List<QnaVO> result = jdbcTemplate.query(sql,rowMapper);
//		return result;
//	}
//	
//	//전체 게시글 수
//	public int selectAllNumBoard() {
//		
//		String sql = "SELECT COUNT(*) FROM BOARDS A JOIN  MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM)";
//		Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class);
//		
//		return cnt;
//	}
//	
//	//페이징 SELECT 쿼리 
//	public List<QnaVO> selectTargetBoard(int section, int pageNum){
//		
//		String sql = "SELECT * FROM (SELECT ROWNUM AS RN, QNABOARDNUM, QNABOARDTITLE, MEMBERNAME, QNABOARDREGDATE, QNABOARDCOUNT FROM (SELECT A.QNABOARDNUM, A.QNABOARDTITLE, B.MEMBERNAME, A.QNABOARDREGDATE, A.QNABOARDCOUNT FROM BOARDS A JOIN MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM) ORDER BY A.QNABOARDNUM DESC)) WHERE RN BETWEEN (?-1)*100 + (?-1)*10 +1 and (?-1)*100 + (?) * 10";
//		
//		List<QnaVO> list = jdbcTemplate.query(sql, rowMapper, section, pageNum, section, pageNum);
//			
//		return list;
//	}
//	
//	public void insertQna(QnaRegiVO qVo, int memberNum) {
//		String sql = "INSERT INTO boards VALUES(BOARDS_SEQ.NEXTVAL, ?, ?, ?,SYSDATE, DEFAULT)";
//		
//		jdbcTemplate.update(sql, memberNum, qVo.getQnaBoardTitle(), qVo.getQnaBoardContent());
//	}
//	
//	public void delQna(Long qnaBoardNum) {
//		String sql = "DELETE FROM BOARDS WHERE QNABOARDNUM = ?";
//		jdbcTemplate.update(sql, qnaBoardNum);
//	}
//	
//	public void updateQna(Long qnaBoardNum, QnaRegiVO qVo) {
//		String sql = "UPDATE BOARDS SET QNABOARDTITLE = ? , QNABOARDCONTENT = ? WHERE QNABOARDNUM = ?";
//		jdbcTemplate.update(sql, qVo.getQnaBoardTitle(), qVo.getQnaBoardContent(), qnaBoardNum);
//	}
//	
//	public List<AdminQnaVO> selectAdminTargetBoard(int section, int pageNum){
//		String sql="SELECT * FROM (SELECT ROWNUM AS RN, QNABOARDNUM, QNABOARDTITLE, MEMBERNAME, QNABOARDREGDATE, QNABOARDCOUNT, COMMENTYN FROM (SELECT A.QNABOARDNUM, A.QNABOARDTITLE, B.MEMBERNAME, A.QNABOARDREGDATE, A.QNABOARDCOUNT, CASE WHEN C.QNABOARDNUM IS NULL THEN 'N' ELSE 'Y' END COMMENTYN FROM BOARDS A JOIN MEMBERS B ON (A.MEMBERNUM = B.MEMBERNUM) LEFT OUTER JOIN COMMENTS C ON(A.QNABOARDNUM= C.QNABOARDNUM) ORDER BY A.QNABOARDNUM DESC)) WHERE RN BETWEEN (?-1)*100 + (?-1)*10 +1 and (?-1)*100 + (?) * 10";
//		
//		List<AdminQnaVO> list = jdbcTemplate.query(sql, _rowMapper, section, pageNum, section, pageNum);
//		
//		return list;
//	}
//	
//	public void insertComments(Long qnaBoardNum, String comments) {
//		String sql="INSERT INTO comments VALUES(comments_seq.NEXTVAL, ?, ?, SYSDATE)";
//		
//		jdbcTemplate.update(sql, qnaBoardNum, comments);
//	}
	
}
