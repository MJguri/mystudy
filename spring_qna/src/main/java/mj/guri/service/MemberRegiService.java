package mj.guri.service;

import org.springframework.beans.factory.annotation.Autowired;

import mj.guri.dao.MemberDAO;
import mj.guri.exception.AlreadyExistingMemberException;
import mj.guri.vo.MemberRegiVO;
import mj.guri.vo.MemberVO;

public class MemberRegiService {

	@Autowired
	private MemberDAO memberdao;
	
	public void regist(MemberRegiVO reg) {
		MemberVO mVo = memberdao.selectById(reg.getMemberId());
		
		if(mVo != null) {
			throw new AlreadyExistingMemberException("이미 존재하는 계정입니다.:"+reg.getMemberId());
		}
		
		memberdao.insertMember(reg); // 회원가입
		
	}
}
