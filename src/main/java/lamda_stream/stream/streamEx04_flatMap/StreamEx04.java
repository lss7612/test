package lamda_stream.stream.streamEx04_flatMap;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx04 {

	public static void main(String[] args) {
		
		//스트링 배열 스트림을 flatMap으로 스트링 스트림으로 만듬
		System.out.println("***EX01***");
		Stream<String[]> strArrStream = Stream.of(new String[] {"abc","def","gbi"}, new String[] {"ABC","DEF","GHI"});
		
		Stream<String> strStream = strArrStream.flatMap(Arrays::stream);
		strStream.map(String::toLowerCase) //소문자로 변환
				 .distinct() //중복제거
				 .sorted() //정렬
				 .forEach(System.out::println); //출력
		System.out.println(); //개행
		
		//-------------------------------------------------------------------------------
		
		String[] lineArr = {
			"belive or not It is true"
			,"Do or do not There is no try"
		};
		//Stream.of 로 스트림 생성
		System.out.println("Stream of 로 스트림 생성");
		Stream<String> lineStream = Stream.of(lineArr);
		lineStream.forEach(System.out::println);
		System.out.println();
		
		//Arrays.stream 로 스트림 생성
		System.out.println("Stream of 로 스트림 생성");
		lineStream = Arrays.stream(lineArr);
		lineStream.forEach(System.out::println);
		System.out.println();

		//flatMap이용 스트링을 잘라서 Array로 만든 스트림 이용
		lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" ")))
				  .forEach(System.out::println);
		System.out.println();
		
		
		
		//-------------------------------------------------------------------------------
		
		//타입 T의 스트림형태를 여러개 가지고 있는 스트림이 있을 수 있다.
		//그런애를 변환하려면 map과 flatMap을 혼용한다.
		
		Stream<String> strStream01 = Stream.of("AAA","BBB","CCC","DDD","EEE");
		Stream<String> strStream02 = Stream.of("AaA","BbB","sCC","dfDD","eEE");
		
		Stream<Stream<String>> sumStream = Stream.of(strStream01,strStream02);
		
		Stream<String> strStreamEx = sumStream.map(s->s.toArray(String[]::new)) //1. 스트림s를 받아와서 String배열로 바꾸어준다. *map이용
													   .flatMap(Arrays::stream); //2. String배열을 flatMap을 이용하여 Stream<String>으로 바꾸어준다.
//		strStreamEx.forEach(System.out::println);//출력결과
		
	}
	
}
