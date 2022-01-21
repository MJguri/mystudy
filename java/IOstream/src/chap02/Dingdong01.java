package chap02;

public class Dingdong01 implements Runnable{

	@Override
	public void run() { // main에서 벗어난 스레드 동작 메서드
		for(int i=0;i<5;i++) {
			System.out.println("동"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
