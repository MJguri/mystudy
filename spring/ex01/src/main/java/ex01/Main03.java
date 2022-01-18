package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 별도의 설정이 없는 경우 스프링 컨테이너가 관리하는 객체는 싱글턴 형태를 가진다.
		
		//1. 스프링 빈 설정 파일이 어디 있는가?? => 읽어오세요.
				GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
				
		//2. 스프링 컨테이너에 생선된 객체를 얻어온다.
		Greeter gt1 = ctx.getBean("greeter", Greeter.class);
		Greeter gt2 = ctx.getBean("greeter", Greeter.class);
		
		System.out.println("(gt1==gt2) : " + (gt1 == gt2));
		ctx.close();
	}

}
