package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.config.ConfMain;
import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main01 {

	public static void main(String[] args) {
//		ApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(JavaConfig1.class);
		//												목록 리스트
		
		// 자바 설정파일 두개이상 가져오는 방법 
		// 1. 매개값을 두개이상 넣어서 만든다.
		
//		ApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(ConfigPart1.class,ConfigPart2.class);
		
		// 2. 자바 설정파일을 하나로 묶어서 가져오는 방법
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ConfMain.class);
		////////////////////////////////////////////////////////////////////////////////
		
		// 자바설정과 xml설정을 합쳐서 가져오는 방법
		// 1. 자바설정 베이스로 xml설정을 가져와서 합치는 방법
		// JavaMainConfig.java  (+sub-config.xml)
//		ApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(JavaMainConfig.class);
		
		// 2. xml설정을 베이스로 자바설정을 가져와서 합치는 방법
		// main-config.xml (+JavaSubConfig.java)
//		ApplicationContext ctx = 
//				new GenericXmlApplicationContext("classpath:main-config.xml");
		
		
//		------------------------------------------------------
		// 빈 객체 불러오기
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc",MemberRegisterService.class);
		
		MemberDao dao = new MemberDao();
		// 스프링 X
		MemberRegisterService regSvc1 = new MemberRegisterService(dao);
		
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("ko@daum.net");
		regReq.setName("고길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		
		regSvc.regist(regReq);

		infoPrinter.printMemberInfo("ko@daum.net");
		
		
		
	}

}
