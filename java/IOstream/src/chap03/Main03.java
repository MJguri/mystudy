package chap03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main03 {

	public static void main(String[] args) throws Exception {
		// 이미지 파일 읽어오기
		// 파일 객체 읽어오기
		File file = 
		new File("C:\\Users\\inter\\Downloads\\artificial-intelligence-g9ba4ffc09_640.jpg");

		FileInputStream fis = new FileInputStream(file);
		
		int data;    //00101011
		byte[] buf = new byte[100];
		while((data = fis.read(buf))!= -1) {
			System.out.write(buf);
		}
		fis.close();
		
	}

}
