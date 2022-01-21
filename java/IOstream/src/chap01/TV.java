package chap01;

public class TV implements Remocon{

	@Override
	public void turnOn() {
		System.out.println("TV를 켠다.");
	}
	
	void dial() {
		System.out.println("채널을 돌린다.");
	}
}
