package lamda_stream.stream.streamEx05_terminal_operation;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx05 {

	public static void main(String[] args) {
		String[] strArr = {
			"동해물과","백두산이","마르고","닳도록","하나님이","보우하dd사","우리나라"	
		};
		Stream.of(strArr).map($->$+=",").forEach(System.out::print);
		
		System.out.println();
		System.out.println();
		
		boolean isNone = Stream.of(strArr).noneMatch(x->x.length()==0);
		System.out.println(isNone);
		System.out.println();
		System.out.println();
		
		Stream.of(strArr).filter(x->x.charAt(x.length()-1)=='이').map(x->x+=",").forEach(System.out::print);
		
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		
		System.out.println();
		System.out.println();
		
		int count = intStream1.reduce(0, (acc,cur)->acc+1);
		System.out.println(count);
		
		int sum = intStream2.reduce(0, (acc,cur)->acc+cur);
		System.out.println(sum);
		

		System.out.println(intStream3.reduce(Integer::max).getAsInt());

		System.out.println(intStream4.reduce(Integer::min).getAsInt());
	}
	
}
