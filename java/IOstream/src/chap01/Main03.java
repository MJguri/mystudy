package chap01;

public class Main03 {

	public static void main(String[] args) {
		//익명 구현 객체
		Runnable r1 = new Runnable() {	
			@Override
			public void run(String str) {
				System.out.println("출력 : "+str);
			}
		};
		
		//람다식 => 익명구현객체로 만들어진 메서드 객체
		Runnable r2 = str->System.out.println("출력:"+str);
		
		//람다식으로 만들어진 메서드는 어떻게 실행하는가??
		r2.run("이길동");
		
		// 람다식(메서드)  메서드가 가지는 종류
		// 매개값 X  반환타입 X  => 람다식
		// 매개값 O  반환타입 X  => 람다식
		// 매개값 X  반환타입 O  => 람다식
		// 매개값 O  반환타입 O  => 람다식
		
		
		
		
		
		
	}

}
