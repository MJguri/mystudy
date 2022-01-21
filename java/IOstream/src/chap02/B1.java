package chap02;

public class B1 extends Thread{
	private Work w;

	public B1(Work w) {
		this.w = w;
	}

	@Override
	public void run() {
		for (int i=0;i<10;i++) {
			w.mB1();
		}
		System.out.println("B스레드 작업 종료");
	}
}
