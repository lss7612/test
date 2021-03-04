package lamda_stream.lamda.lamdaEx07_메소드참조;

import java.util.function.Function;

public class MethodReference {

	public static void main(String[] args) {
		//하나의 메소드만 호출하는 람다식은 '참조변수::메소드명' 으로 바꿀 수 있다.
		
		//일반 메소드 호출
		Function<String, Integer> func01 = s -> Integer.parseInt(s);
		System.out.println(func01.apply("123"));
		
		//메소드 참조를 이용한 메소드 호출
		Function<String, Integer> func02 = Integer::parseInt; 
		System.out.println(func02.apply("123"));
		
		//생성자의 메소드 참조
		//생성자를 호출하는 람다식도 메소드 참조로 변환 가능하다.
		
	}
	
}
