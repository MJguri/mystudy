package chap02;

public class Main03 {

	public static void main(String[] args) {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("동"+i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
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
