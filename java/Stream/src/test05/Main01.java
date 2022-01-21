package test05;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main01 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		// 배열을 스트림을 옮겨 담는다.
		IntStream stm1 = Arrays.stream(arr);  //스트림 객체
		IntStream stm2 = stm1.filter(n->n%2==1); // 중간연산   조건 => [기능 != 데이터]
		int sum = stm2.sum();  // 중간연산을 통해서 추려진 데이터의 합계를 구하는 최종 연산
		
		System.out.println("홀수의 합계 : "+sum);
	
		//-----스트림의 본 모습 => 메서드 체이닝
		int sum2 = Arrays.stream(arr).filter(n->n%2==0).sum();
		System.out.println("짝수의 합계 : "+sum2);
	}

}
