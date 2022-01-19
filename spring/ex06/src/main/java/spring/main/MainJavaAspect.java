package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.calc.Calculator;
import spring.config.JavaConfig;

public class MainJavaAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Calculator impe = ctx.getBean("impe",Calculator.class);
		long impeResult = impe.factorial(5);
		System.out.println("impeResult의 결과값 : "+impeResult);
		
		
		Calculator rec = ctx.getBean("rec",Calculator.class);
		long recResult = rec.factorial(5);
		System.out.println("recResult의 결과값 : "+recResult);

	}

}
