package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class MainXmlOrder2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopOrder2.xml");

		Calculator impe = ctx.getBean("impe",Calculator.class);
		
		long result1 = impe.factorial(5);// 아직 캐시에 없을때
		long result2 = impe.factorial(5);// 캐시에 존재할 때
		
		System.out.println("결과 1 : "+result1);
		System.out.println("결과 2 : "+result2);
	}

}
