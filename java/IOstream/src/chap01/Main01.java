package chap01;

public class Main01 {

	public static void main(String[] args) {
		
		// 익명 자식 객체  => 익명 구현 객체(추상메서드가 있는 인터페이스를 기반)
		Animal a1 = new Cat();
		
		a1.type="고양이";
		a1.sound();
//		a1.action();
		
		Animal a2 = new Animal() {
				@Override
				void sound() {
					System.out.println("꾸웩꾸웩");
				}
				void action() {
					System.out.println("부리로 쫀다!");
				}
		};
		
		a2.sound();
	//	a2.action();
		
		// 변수의 활용 예시
		//  1. 메서드 내부의 로컬변수
		//  2. 클래스 내부의 인스턴스 멤버 변수
		//  3. 메서드의 매개변수 *** 
		
		method(new Animal() {

			@Override
			void sound() {
				System.out.println("부엉부엉");
			}
			
		});
	}

	private static void method(Animal ani) {
		ani.sound();
	}

}
