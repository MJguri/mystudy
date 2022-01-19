package spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean{
	private String host;

	public void setHost(String host) { // 문자열 객체를 주입 받는다.
		this.host = host;
		System.out.println("Client.setHost() 실행");
	}
	
	public void send() { // 실제 사용할 메서드 
		System.out.println("Client.send() to " + host); // 의존적
	}

	// 빈 객체 소멸시 작동할 메서드
	@Override
	public void destroy() throws Exception {
		System.out.println("빈 소멸");
	}
	
	// 빈 객체 초기화 시 작동할 메서드
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("빈 초기화");
	}
}
