package chap02;

public class Main07 {

	public static void main(String[] args) {
		Calc c = new Calc();
		
		User1 u1 = new User1();
		u1.setCal(c);
		u1.start();
		
		User2 u2 = new User2();
		u2.setCal(c);
		u2.start();
		
		//user1과 user2가 동시에 setMem메서드를 제어하기 시작함
	}

}
