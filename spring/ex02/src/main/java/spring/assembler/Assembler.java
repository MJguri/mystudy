package spring.assembler;

import spring.dao.MemberDAO;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

public class Assembler { // 클래스들 간의 조립
	
	private MemberDAO memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberDao = new MemberDAO();
		regSvc = new MemberRegisterService(memberDao); // Assembler 클래스에서 생성한 memberDAO객체를 주입해준다.
		pwdSvc = new ChangePasswordService(memberDao);
	}
	
	public MemberDAO getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	
}
