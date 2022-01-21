package chap02;

public class Calc {
	private int mem;

	public int getMem() {
		return mem;
	}

	public synchronized void setMem(int mem) {
		//  하나의 스레드가 동작되는 동안 다른 스레드는 사용 불가
		this.mem = mem;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+this.mem);
	}
	
	
}
