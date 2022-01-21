package test05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main02 {

	public static void main(String[] args) {
		// 스트림 객체 생성
		// 1. 배열을 이용해서 스트림 객체를 생성   Arrays 
		//    1) 기본 타입 배열
		int[] arr1 = {1,2,3,4,5};
		IntStream stm1 = Arrays.stream(arr1);
		
		double[] arr2 = {17.3,23.56,53.123};
		DoubleStream stm2 = Arrays.stream(arr2);
		
		//    2) 참조 타입 배열
		String[] arr3 = {"콩순이","콩콩이","밤이","송이"};
		Stream<String> stm3 = Arrays.stream(arr3);
		
		// 2. 컬렉션을 이용해서 스트림 객체 생성  : 컬렉션내부에 메서드 stream() 
		List<String> list = Arrays.asList("에디","크롱","포비","루피");
		Stream<String> stm4 = list.stream();
		
		
		
	}

}
