package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.aspect.ExeTimeAspect2;
import spring.calc.Calculator;
import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
	
	@Bean
	public ExeTimeAspect2 exeTimeAspect2() {
		return new ExeTimeAspect2();
	}
	
	@Bean
	public Calculator impe() {
		return new ImpeCalculator();
	}
	
	@Bean
	public Calculator rec() {
		return new RecCalculator();
	}
}
