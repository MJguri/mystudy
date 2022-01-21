package test05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main06 {

	public static void main(String[] args) {
		// 최종 연산 : 스트림으로 추려진 데이터를 최종 결과물로 만드는 연산
		// sum()
		int[] jumsu = {54,71,69,48};
		int sum = Arrays.stream(jumsu)
			  .filter(n->n>60)
			  .sum();
		System.out.println("합계 : "+sum);
		
		List<Game> list = new ArrayList<>();
		
		list.add(new Game("C&C 3","RTS",17000));
		list.add(new Game("PERSONA 5 ","RPG",69800));
		list.add(new Game("Warcraft 3","RTS",36000));
		list.add(new Game("LoL","AOS",0));
		list.add(new Game("The Witcher","RPG",34800));
		
		int rpg = list.stream()   //다수의 게임 객체
					  .filter(lksnlf->lksnlf.getType().equals("RPG")) //장르가 RPG인 게임만 추출
					  .mapToInt(g->g.getPrice())
					  .sum();	//RPG 장르의 게임 가격 합계
		System.out.println("RPG 장르의 게임 가격 합계 : "+rpg);
		
		
	}

}
