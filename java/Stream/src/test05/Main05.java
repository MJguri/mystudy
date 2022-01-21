package test05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main05 {

	public static void main(String[] args) {
		// 중간 연산은 반환타입도 스트림이므로 연달아 사용 가능
		int[] jumsu = {54,71,69,48};
		Arrays.stream(jumsu)				//{54,71,69,48}
			  .mapToObj(n->(n>60)?"합격":"불합격") //{"불합격","합격","합격","불합격"}
			  .filter(str->str.equals("합격"));//{"합격","합격"}
		
		
		// 예시
		List<Game> list = new ArrayList<>();
		
		list.add(new Game("C&C 3","RTS",17000));
		list.add(new Game("PERSONA 5 ","RPG",69800));
		list.add(new Game("Warcraft 3","RTS",36000));
		list.add(new Game("LoL","AOS",0));
		list.add(new Game("The Witcher","RPG",34800));
		
		list.stream()   //다수의 게임 객체
			.filter(lksnlf->lksnlf.getType().equals("RPG")) //장르가 RPG인 게임만 추출
			.mapToInt(g->g.getPrice());				// 추출된 게임 객체에서 가격정보 추출
		
		
		//method();
	}

	private static void method(Game ksdbjdf) {
		
		
	}

}
