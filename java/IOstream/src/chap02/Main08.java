package chap02;

public class Main08 {

	public static void main(String[] args) {
		Work w= new Work();
		
		A1 a = new A1(w);
		B1 b = new B1(w);

		a.start();
		b.start();
	}

}
