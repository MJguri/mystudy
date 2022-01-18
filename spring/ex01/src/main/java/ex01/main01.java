package ex01;

public class main01 {

	public static void main(String[] args) {
		//기존 자바 코드 => 객체(인스턴스) 사용하는 방법

		Greeter gt = new Greeter();
		gt.setFormat("%s님, 안녕하세요");
		String msg = gt.greet("홍길동씨");
		
		System.out.println(msg);
		
		
		
		
	}

}
