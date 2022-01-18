package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.service.MemberRegisterService;

@Configuration
public class ConfigPart1 {

	@Bean   
	public spring.dao.MemberDao memberDao() {
		return new spring.dao.MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
}
