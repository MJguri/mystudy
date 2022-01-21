package chap02;

public class Main04 {

	public static void main(String[] args) {
		Thread th = new Dingdong02();
		th.setName("두번째 스레드");
		th.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("딩"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		

	}

}
