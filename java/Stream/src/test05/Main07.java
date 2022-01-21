package test05;

import java.util.Arrays;

public class Main07 {

	public static void main(String[] args) {
		//forEach()   최종연산 => 가져온 스트림 데이터를 반복한다.
		String[] subject = {"kor","math","eng"};
		Arrays.stream(subject)
			  .filter(str->str.length()==3)
			  .forEach(s->System.out.println(s));
			 
		// 최종 연산은 최종이기때문에 추가 연산을 붙일수 없다.
	}

}
