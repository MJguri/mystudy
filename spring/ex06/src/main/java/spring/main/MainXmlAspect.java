package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class MainXmlAspect {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopAspect.xml");
		
		Calculator impe = ctx.getBean("impe",Calculator.class);
		long impeResult = impe.factorial(5);
		System.out.println("impeResult의 결과값 : "+impeResult);
		
		
		Calculator rec = ctx.getBean("rec",Calculator.class);
		long recResult = rec.factorial(5);
		System.out.println("recResult의 결과값 : "+recResult);

	}

}
