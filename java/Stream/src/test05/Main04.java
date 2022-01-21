package test05;

import java.util.Arrays;

public class Main04 {

	public static void main(String[] args) {
		// 중간 연산 ->  매핑 map,mapToObj =>  입력된 데이터와 다른 타입의 데이터로 전환
		int[] jumsu = {54,71,69,48};
		Arrays.stream(jumsu)
			  .mapToObj(n->(n>60)?"합격":"불합격"); // int형 숫자를 문자열로 전환
		
		String[] subject = {"kor","math","eng"};
		Arrays.stream(subject)
			  .map(str->str.length());  // 문자열을 int형으로 전환

	}

}
