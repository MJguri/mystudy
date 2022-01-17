package spring.printer;

import spring.dao.MemberDAO;
import spring.vo.Member;

public class MemberInfoPrinter {
	
	private MemberDAO memDao;
	private MemberPrinter printer;
	
	//setter 메서드를 통해서 두 객체를 주입받는다.
	public void setMemDao(MemberDAO memDao) {
		this.memDao = memDao;
	}

	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		
		if(member == null) {
			System.out.println("데이터없음!");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}

	
}
