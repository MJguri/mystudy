package mj.guri.service;

import org.springframework.beans.factory.annotation.Autowired;

import mj.guri.dao.MemberDAO;
import mj.guri.exception.IdPasswordNotMatchingException;
import mj.guri.vo.AuthInfo;
import mj.guri.vo.MemberVO;

public class AuthService {
	
	@Autowired
	private MemberDAO dao;
	
	public AuthInfo authenticate(String memberId, String memberPassword) {
		MemberVO m = dao.selectById(memberId);
		
		if(m==null) {
			throw new IdPasswordNotMatchingException();
		}
		if(!m.getMemberPassword() .equals(memberPassword)) {
			throw new IdPasswordNotMatchingException();
		}
		
		return new AuthInfo(m.getMemberId(), m.getMemberName(), m.getMemberNum());
	}
	

}
