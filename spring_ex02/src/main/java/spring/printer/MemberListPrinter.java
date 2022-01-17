package spring.printer;

import java.util.Collection;

import spring.dao.MemberDAO;
import spring.vo.Member;

public class MemberListPrinter {
	
	private MemberDAO memberDao;
	private MemberPrinter printer;
	
	
	
	public MemberListPrinter(MemberDAO memberDao, MemberPrinter printer) {
		super();
		this.memberDao = memberDao;
		this.printer = printer;
	}



	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members) {
			printer.print(m);
		}
	}
}
