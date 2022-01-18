package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class JavaSubConfig {
	
	@Autowired
	private MemberDao dao;

	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean 
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter info = new MemberInfoPrinter();
			info.setMemberDao(dao);
			info.setPrinter(printer());
		return info;
	}
}
