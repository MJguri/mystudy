package spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.MemberDAO;
import spring.exception.AlreadyExistingmemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService { //회원 정보를 저장하기위한 클래스
	
	private MemberDAO memberDao; // = new MemberDAO(); 사용할 객체 직접 생성
	
	@Autowired              // 자동 주입 활성화 
	public MemberRegisterService(MemberDAO memberDao) { // 사용할 객체를 외부에서 주입받는 형태 
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		// 이미 가입된 계정이 있는가?
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyExistingmemberException("이메일중복" + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}

}
