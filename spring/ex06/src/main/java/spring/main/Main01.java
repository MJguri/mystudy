package spring.main;

import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

public class Main01 {

	public static void main(String[] args) {
		ImpeCalculator impe = new ImpeCalculator();
		long impeResult = impe.factorial(5);  //  5!
		
		RecCalculator rec = new RecCalculator();
		long recResult = rec.factorial(5);     // 5!
	
	
		System.out.println("impeResult의 결과값 : "+impeResult);
		System.out.println("recResult의 결과값 : "+recResult);
	}

}
