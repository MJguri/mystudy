package spring.service;

import spring.dao.MemberDAO;
import spring.exception.MemberNotFoundException;
import spring.vo.Member;

public class ChangePasswordService { //암호를 변경하기 위한 기능을 담당하는 클래스
	
	private MemberDAO memberDao = new MemberDAO();

	public ChangePasswordService(MemberDAO memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member ==null ) {
			throw new MemberNotFoundException();
		}
		else {
			member.changePassword(oldPwd, newPwd);
			
			memberDao.update(member);
		}
		
	}
	

}
