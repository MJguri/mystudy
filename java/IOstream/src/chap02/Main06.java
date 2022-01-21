package chap02;

public class Main06 {

	public static void main(String[] args) {
		SUMThread st = new SUMThread();
		st.start();
		
		try {
			st.join();// st스레드가 마칠때까지 main스레드가 기다리게 만듦
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("1부터 100까지의 합 : "+st.getSum());
	}

}
