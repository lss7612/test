package lamda_stream.optional.optionalEx01;

import java.util.Optional;

public class OptionalEx01_01 {
	
	public static void main(String[] args) {
		
		//Optional<T> 는 지네릭 클래스로 T타입의 객체를 감싸는 래퍼클래스이다.
		//최종 연산의 결과를 그냥 반환하지 않고 Wrapper Class에 담아 반환한다.
		//그로 인해 if(결과==null)과 같은 조건문을 쓰지 않아도 클래스 내부에서 널체크가 가능하다.
		
		//Optional객체 생성시
		//1. of 사용
		Optional.of("123");
		//2. ofNullable 사용
		Optional.ofNullable("123");
		
		//만약 참조변수가 null일 가능성이 있다면, of 대신 of Nullable 사용해야한다.
		try {
			Optional.of(null);
		} catch (Exception e) {
			System.out.println("에러발생  에러이름 : " + e);
		}
		
		Optional.ofNullable(null); //에러발생하지 않음! 장점 : 트라이캐치하지 않아도 된다.
		
		
		int result = Optional.of("123")
				.filter(x -> x.matches("^[0-9]+$")) //optional에서 받은 참조변수가 숫자인지 확인하는 정규식
				.map(Integer::parseInt) //내부의값을 parseInt
				.orElse(-1); //만약 null을 받을 경우 -1 반환
		System.out.println(result);
		//위와 같이 중간에 null 체크를 하지 않아도 되는 편리함이 있따
		
	}
	
	
}
