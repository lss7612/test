package lamda_stream.optional.optionalEx02;

import java.util.Optional;

public class OptionalEx02 {

	public static void main(String[] args) {
		
		//orElse 의 변형으로 null일때 발생할 함수를 정의하거나, null일 때 throw할 에러를 지정할 수 있다.
		//1. 함수 정의 orElseGet
		try {
			String str1 = (String) Optional.of(null).orElseGet(String::new);
			String str2 = (String) Optional.of(null).orElseThrow(NullPointerException::new);
		} catch (Exception e) {
			System.out.println("에러"+e);
		}
		
		
	}
	
}
