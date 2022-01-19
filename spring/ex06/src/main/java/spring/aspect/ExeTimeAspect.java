package spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExeTimeAspect {// 스프링에서 적용할 프록시 객체 : 순수한 자바코드
	
	public  Object method(ProceedingJoinPoint joinPoint) throws Throwable{
							// 핵심기능을 가진 객체에 대한 정보를 가진 객체
		long start = System.nanoTime();
		
		try {
			Object result = joinPoint.proceed();
// 			실제는 long 		핵심기능 어떤 이름을 가졌든지간에 구동해라!!
			return result;
		}finally {
			
			//1. 핵심기능을 수행하는 메서드의 이름은?
			long end = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			// 핵심기능을 가진 메서드 정보
			System.out.printf("%s.%s(%s)의 실행시간 : %d \n",
			joinPoint.getTarget().getClass().getSimpleName(),    // 소속된 해당객체의 이름을 알수 있다
			sig.getName(),
			Arrays.toString(joinPoint.getArgs()),
			(end-start));
		}
	}
}
