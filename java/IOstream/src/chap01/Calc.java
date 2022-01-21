package chap01;

public class Calc {
	int a,b;
	
	Calc(){}
	
	public Calc(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.println("인스턴스가 생성되었습니다.");
	}
	
	public int iAdder(int a, int b) {
		return a+b;
	}
	
	public static int sAdder(int a, int b) {
		return a+b;
	}
}
