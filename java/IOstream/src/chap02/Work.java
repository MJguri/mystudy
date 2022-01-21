package chap02;

public class Work {
	public synchronized void mA1() {
		System.out.println("A1()작업 실행");
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	public synchronized void mB1() {
		System.out.println("B1()작업 실행");
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
