package spring.main;

import spring.calc.ExeTimeCalculator;
import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

public class Main02 {

	public static void main(String[] args) {
		ExeTimeCalculator impe = new ExeTimeCalculator(new ImpeCalculator());
		long impeResult = impe.factorial(5);  //  5!
		
		ExeTimeCalculator rec = new ExeTimeCalculator(new RecCalculator());
		long recResult = rec.factorial(5);     // 5!
	
	
		System.out.println("impeResult의 결과값 : "+impeResult);
		System.out.println("recResult의 결과값 : "+recResult);

	}

}
