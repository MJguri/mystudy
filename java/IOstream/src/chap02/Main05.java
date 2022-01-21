package chap02;

public class Main05 {

	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
			Thread thread = new CalcThead("THREAD : "+i);
			if(i!=10) {
				thread.setPriority(1);// 그외 스레드는 우선순위 1
			}else {
				thread.setPriority(10);//10번 스레드만 우선순위 10
			}
			thread.start();
		}

	}

}
