package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.bean.Client3;
import spring.config.JavaConfig;

public class Main04 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		// 사용할 빈 객체를 불러와야함 
		Client3 client3_1 = ctx.getBean("client3",Client3.class);
		Client3 client3_2 = ctx.getBean("client3",Client3.class);
		
		System.out.println("client3_1 == client3_2 : " + (client3_1 == client3_2));

	}

}
