package spring.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {
	
	private Map<Long,Object> cache = new HashMap<>();

	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		// 5팩토리얼을 구했다. 계산 결과를 '기억'
		// 다음에 5팩토리얼을 구할 때 계산하지 않고 기억된 결과를 꺼내보도록 하는 것 : 캐시
		
		long num = (long)joinPoint.getArgs()[0];  
		
		if(cache.containsKey(num)) {
			System.out.println(num+"에 해당하는 캐시가 존재한다.");
			return cache.get(num);
		}
		
		Object result = joinPoint.proceed(); //팩토리얼을 계산하기 위한 메서드 호출
		//새로운 결과를 캐시에 기억해야함
		cache.put(num, result);
		
		return result;
		
	}
}
