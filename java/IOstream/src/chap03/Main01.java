package chap03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main01 {

	public static void main(String[] args) throws Exception {
		//텍스트 파일 읽어오기
		// 1. 읽어올 파일 객체 만들기
		File file = 
		new File("C:\\ExampleData\\Green20211012\\Recruit\\test03\\src\\chap03\\Main.java");

		// 2. 해당 파일에 빨대를 꽂아 봅시다.
		FileReader fr = new FileReader(file);
		
		char[] cbuf = new char[100];// 파일에서 데이터를 읽어오는 '수레'
		int readCharNo;   // 수레 안에 데이터 양 => -1이면 빈수레
		
		while((readCharNo = fr.read(cbuf)) != -1) {
			String data = new String(cbuf); 
			System.out.println(data);
		}
		fr.close();
		
		
		
		
	}

}
