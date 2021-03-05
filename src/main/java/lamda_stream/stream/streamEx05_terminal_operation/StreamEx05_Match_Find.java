package lamda_stream.stream.streamEx05_terminal_operation;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamEx05_Match_Find {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		// anyMatch : 하나라도 있는지 확인한다.
		// noneMatch : 하나도 없는지 확인한다.
		// allMatch : 조건이 모두 맞는지 확인한다.
		
		boolean result;
		//배열중에 3이 넘는애가 있는지 확인한다.
		result = IntStream.of(arr).anyMatch(num -> num > 3);
		System.out.println(result); //true
		
		//배열중 5가 넘는애가 없는지 확인한다.
		result = IntStream.of(arr).noneMatch(num -> num > 5);
		System.out.println(result);//true
		
		//배열 중 4가 넘는애가 없는지 확인한다
		result = IntStream.of(arr).noneMatch(num -> num > 4);
		System.out.println(result);
		
		//배열의 요소 모두가 1 이상인지 확인한다.
		result = IntStream.of(arr).allMatch(num -> num >= 1);
		System.out.println(result); //true
		
		
		//--------------------------------------------------------------------------------------------------
		
		
		//find는 정확히 더 공부해야함
		
		
	}
	
}
