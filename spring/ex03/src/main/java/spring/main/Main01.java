package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.printer.MemberInfoPrinter;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main01 {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class);
                                                     //( 빈객에체 등록된 id값 ,  타입.class)
		MemberInfoPrinter info = ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("hong@naver.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		
		regSvc.regist(regReq);  // 회원가입기능 작동
		
		info.printMemberInfo("hong@naver.com"); // 가입된 회원정보 출력하기 
	}

}
