package spring.calc;

public class RecCalculator implements Calculator{// 재귀함수를 이용한 방법

	@Override
	public long factorial(long num) {// 재귀 호출을 이용한 방법   // 주기능
							// 5
		
		//long start = System.currentTimeMillis();
		try {
			if(num==0) {
				return 1;
			}else {							// fac(5)
				return num*factorial(num-1);  // 5*(fac(4))
											  //      4*(fac(3))
											  //             3*(fac(2))
											  //                    2*(fac(1))
											  //                          1*(fac(0))
			}
		}finally {
			//long end = System.currentTimeMillis();
			//System.out.println("RecCalculator.factorial("+num+")의  계산 시간 : "+(end-start));
		}

	}

}
