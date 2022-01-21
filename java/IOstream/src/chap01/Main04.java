package chap01;

public class Main04 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		// Ref 인터페이스로 람다식을 만들어 봅시다.
		Ref r1 = (x,y)->{return x+y;};
		System.out.println("람다 1 결과"+r1.test(a, b));
		
		// 메서드 참조 (람다가 iAdder메서드를 참조하고 있다.
		Calc c0 = new Calc();
		Ref r2 = (x,y)->{return c0.iAdder(x,y);};
		System.out.println("람다 2 결과"+r2.test(a, b));

		m1(a,b);//( m1메서드가 m2메서드를 참조한다.)
		
		// 메서드 참조되는 경우 람다를 더욱 간단하게 줄일수 있다
		Ref r3 = c0::iAdder; //람다로 c0 인스턴스의 iadder 메서드를 그대로 사용할 겁니다.
		System.out.println("람다 3 결과"+r3.test(a, b));

	
		// 정적 메서드 참조(인스턴스가 필요없다. 클래스 이름 직접 사용)
		Ref r4 = (x,y)->{return Calc.sAdder(x,y);};
		System.out.println("람다 4 결과"+r4.test(a, b));
	//  => 
		Ref r5 = Calc::sAdder;
		System.out.println("람다 5 결과"+r5.test(a, b));
		
		// 생성자(메서드) 참조
		InsCeate<Calc> ic1 = (x,y)->{return new Calc(x,y);};
		Calc c1 = ic1.create(a, b);
	//  => 
		InsCeate<Calc> ic2 = Calc::new;
		Calc c2 = ic2.create(a, b);
		
		
		
		
		
		
	}

	private static int m1(int a, int b) {
		return m2(a,b);
	}

	private static int m2(int a, int b) {
		return a+b;
	}

}
