package lamda_stream.lamda.lamdaEx01_함수형인터페이스정의;

@FunctionalInterface
public interface Myfunction {
	public void run();
//	public void run2(); //오류 Invalid '@FunctionalInterface' annotation; Myfunction is not a functional interface
	//funtional Interface 어노테이션이 붙은 interface에는 하나의 메소드만 만들어놓을 수 있다.
	//해당 인터페이스 구현체(인스턴스)에 익명함수(람다식)을 부여하게 된다면 인터페이스 내부의 정의된 이름의 함수에 할당된다.
	//단, 매개변수의 개수는 일치시켜야한다.
}
