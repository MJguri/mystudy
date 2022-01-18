package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.service.MemberRegisterService;

@Configuration
@Import({ConfSub.class})
public class ConfMain {
	
	@Bean   
	public spring.dao.MemberDao memberDao() {
		return new spring.dao.MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
}
