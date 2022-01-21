package chap02;

public class CalcThead extends Thread{
	public CalcThead(String name) {
		setName(name);
	}

	@Override
	public void run() {//  쓰레드가 길게 유지되는 상황
		for(int i=0;i<20000000;i++){}
	
		System.out.println("쓰레드 이름 : " + getName());
	}
	
	
}
