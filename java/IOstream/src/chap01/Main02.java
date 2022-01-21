package chap01;

public class Main02 {
	
	Remocon r0 = new Remocon() {//인스턴스 멤버 필드(변수)
		@Override
		public void turnOn() {
			
		}
	};

	public static void main(String[] args) {
		Remocon r1 = new TV();  //로컬 변수
		r1.turnOn();
//		r1.dial();
		
		Remocon r2 = new Remocon() { //인터페이스를 구현한 익명 인스턴스
			@Override
			public void turnOn(){
				System.out.println("전원을 켠다.");
			}	
		};
		r2.turnOn();
		// 변수의 활용 예시   <= 익명 구현 객체
		//  1. 메서드 내부의 로컬변수
		//  2. 클래스 내부의 인스턴스 멤버 변수
		//  3. 메서드의 매개변수 *** 
		method(new Remocon() {
			@Override
			public void turnOn() {
				System.out.println("기능켜기");
			}
		});
	}

	private static void method(Remocon con) {
		con.turnOn();	
	}

}
