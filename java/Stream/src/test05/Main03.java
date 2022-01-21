package test05;

import java.util.Arrays;

public class Main03 {

	public static void main(String[] args) {
		// 중간 연산 ->  필터 filer( 조건[T/F] )
		int[] jumsu = {54,71,69,48};
		Arrays.stream(jumsu)
			  .filter(n->n>60);
		
		String[] subject = {"kor","math","eng"};
		Arrays.stream(subject)
			  .filter(str->str.length()==3);
	}

}
