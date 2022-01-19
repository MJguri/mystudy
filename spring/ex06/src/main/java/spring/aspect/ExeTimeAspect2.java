package spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect2 {// 순수자바클래스가 아니게 되도록 어노테이션을 붙임
	
	@Pointcut("execution(public * spring.calc..*(..))")
	private void publicTarget() {}
	
	
	@Around("publicTarget()")
	public  Object method(ProceedingJoinPoint joinPoint) throws Throwable{
		// 핵심기능을 가진 객체에 대한 정보를 가진 객체
		long start = System.nanoTime();

		try {
			Object result = joinPoint.proceed();
			//실제는 long 		핵심기능 어떤 이름을 가졌든지간에 구동해라!!
			return result;
		}finally {
			long end = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			// 핵심기능을 가진 메서드 정보
			System.out.printf("%s.%s(%s)의 실행시간 : %d \n",
					joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(),
					Arrays.toString(joinPoint.getArgs()),
					(end-start));
		}
	}
}
