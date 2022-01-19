package spring.calc;

public class ImpeCalculator implements Calculator{ // 재귀함수 없이 팩토리얼 구하는 방법

	@Override
	public long factorial(long num) {  // 주기능
		//execution(public * spring.calc..*(..))	
		//long start = System.currentTimeMillis(); 
		long result = 1;
		for(long i=1;i<=num;i++){
			result*=i;    // num=4  (1)*1 ,(1*1)*2, (1*1*2)*3, (1*1*2*3)*4 
		}
		
		//long end = System.currentTimeMillis();
		
		//System.out.println("ImpeCalculator.factorial("+num+")의  계산 시간 : "+(end-start));
		return result;
	}

}
