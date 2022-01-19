package spring.calc;

public class ExeTimeCalculator implements Calculator{// 프록시 객체 : Main에서는 동작하는지 궁금하지 않는 클래스
	
	private Calculator calc;
	
	public ExeTimeCalculator(Calculator calc) {
		this.calc = calc;
	}

	@Override
	public long factorial(long num) {// 시간 측정  :  공통의 보조기능
		
		//long start = System.currentTimeMillis();
		long start = System.nanoTime();
		
		long result = calc.factorial(num);
		
		//long end = System.currentTimeMillis();
		long end = System.nanoTime();
		
		System.out.println(calc.getClass().getSimpleName()+"의 실행 시간 : "+(end-start));
		return result;
	}  
	
	
}
