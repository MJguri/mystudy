package test05;

import java.util.Arrays;
import java.util.List;

public class Main08 {

	public static void main(String[] args) {
		// 최종 연산 - reduce("전달받은 스트림이 없는 경우",[기능]) 줄이기 => 하나의 데이터가 나오도록 유도
		List<String> heroName = 
			Arrays.asList("SpiderMan",
						"Hulk",
						"AntMan",
						"IronMan",
						"BatMan",
						"SuperMan");
		
			String name = heroName.stream()
								  .reduce("NoName",(name1,name2)->{
									  if(name1.length() > name2.length()) {
										  return name1;
									  }else {
										  return name2;
									  }
								  });
			System.out.println("이름이 가장 긴 히어로네임 : "+name);
	}

}
