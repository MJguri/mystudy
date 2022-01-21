package chap02;

public class Dingdong02 extends Thread{

	@Override
	public void run() {// 새로운 main메서드
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
