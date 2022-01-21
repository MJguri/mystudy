package chap03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main04 {

	public static void main(String[] args) throws Exception{
		//이미지 복제
		File originalFile =
		new File("C:\\Users\\inter\\Downloads\\artificial-intelligence-g9ba4ffc09_640.jpg"); 
		File targetFile = 
		new File("C:\\ExampleData\\Green20211012\\TEMP\\hacker.jpg");
		
		FileInputStream fis = new FileInputStream(originalFile);
		FileOutputStream fos = new FileOutputStream(targetFile);
		
		int readByteNo;
		byte[] readBytes = new byte[100];
		while ((readByteNo =fis.read(readBytes))!=-1) {//이미지를 읽어와서
			fos.write(readBytes);	//바로 기록
		}
		fos.flush();
		fos.close();
		fis.close();
		
		System.out.println("복사가 완료되었습니다.");
		
		
		
		
		
		
		
	}

}
