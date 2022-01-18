package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;
import spring.service.MemberRegisterService;

//import spring.dao.MemberDao;

@Configuration   // 이 클래스는 설정파일로 사용됩니다.
public class JavaConfig1 {

// <bean id="memberDao" class="spring.dao.MemberDao"></bean>  
	// 스프링 자바 설정파일 => 빈객체를 메서드로 생성한다.
	@Bean   
	public spring.dao.MemberDao memberDao() {
		return new spring.dao.MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
									//	<constructor-arg ref="memberDao"/>
	}
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
//		return new MemberInfoPrinter();
		
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
//		<property name="memberDao" ref="memberDao"/>
//		infoPrinter.setPrinter(printer());
				
		return infoPrinter;
	}
}
