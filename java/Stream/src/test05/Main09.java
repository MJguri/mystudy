package test05;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main09 {

	public static void main(String[] args) {
		List<Hero> heroList = new ArrayList<>();
		
		heroList.add(new Hero("스파이더맨","마블",650));
		heroList.add(new Hero("배트맨","DC",600));
		heroList.add(new Hero("아이언맨","마블",750));
		heroList.add(new Hero("아쿠아맨","DC",800));
		heroList.add(new Hero("캡틴아메리카","마블",700));
		heroList.add(new Hero("수퍼맨","DC",1000));
		heroList.add(new Hero("앤트맨","마블",800));
		
		Optional<Hero> he = heroList.stream()
							.filter(hero->hero.getAffiliation().equals("마블"))
							.reduce((hero1,hero2)->{
								if(hero1.getCombatPower() > hero2.getCombatPower()) {
									return hero1;
								}else {
									return hero2;
								}
							});
		System.out.println("마블에서 가장 전투력이 높은 히어로 : "+he.get().getName());
	}

}
