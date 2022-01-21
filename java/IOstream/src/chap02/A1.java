package chap02;

public class A1 extends Thread{
	
	private Work w;

	public A1(Work w) {
		this.w = w;
	}

	@Override
	public void run() {
		for (int i=0;i<10;i++) {
			w.mA1();
		}
		System.out.println("A스레드 작업 종료");
	}
	
	

}
