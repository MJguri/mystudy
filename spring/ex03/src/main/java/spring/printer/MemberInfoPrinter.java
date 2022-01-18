package spring.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.dao.MemberDAO;
import spring.vo.Member;

public class MemberInfoPrinter {
	
	@Autowired       // setter메서드를 이용한 경우에는 필드에 붙여도 되고 setter메서드에 직접붙여도된다.
	private MemberDAO memDao;
	private MemberPrinter printer;
	
	//@Autowired
	public void setMemDao(MemberDAO memDao) {
		this.memDao = memDao;
	}
	//setter 메서드를 통해서 두 객체를 주입받는다.
	@Autowired
	@Qualifier("chk01") 
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
