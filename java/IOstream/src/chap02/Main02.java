package chap02;

public class Main02 {

	public static void main(String[] args) {
		Thread th = new Thread(new Dingdong01());
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
