package chap03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main02 {

	public static void main(String[] args) throws Exception {
		//텍스트 파일 출력하기
		
		// 출력 위치에 출력을 위한 파일명 작성
		File file = new File("C:\\ExampleData\\Green20211012\\TEMP\\file.txt");
		
		//파일에 출력하기 위한 객체 생성
		FileWriter fw = new FileWriter(file);
		
		fw.write("FileWriter는 한글로된 \r\n");
		fw.write("바로 출력할 수 있습니다. \r\n");
		fw.flush();
		fw.close();
		
		System.out.println("파일에 출력 완료");

	}

}
