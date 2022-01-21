package test05;

public class ClassA {
	public int method(int a, int b) {
		int c = a+b;
		return c;
	}
}
//람다식 => 메서드=데이터(인스턴스)
//      최대한 불필요한 정보를 제거   => 추정 가능한 정보는 최대한 생략 
/*

	(a, b)->{
		int c = a+b;
		return c;
	}

 
 
 
 
 
 */
