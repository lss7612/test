package threadTest.threadEx01;

public class ThreadEx01 {

	public static void main(String[] args) {
		//ThreadEx01_01의 경우 Thread Class를 확장하고있다.
		//Thread Class는 Runnable 인터페이스를 상속받고 있으며, 내부에 getName() 메소드를 가지고 있다.
		ThreadEx01_01 t1 = new ThreadEx01_01();
		
		//ThreadEx01_02의 경우 Runnable을 상속받아 사용한다.
		//새로운 쓰레드를 만들기 위해서는 Thread Class 내부 생성자 중 
		//runnable 인터페이스를 상속받은 클래스를 인스턴스화한 후 해당 객체를 Thread 생성자의 매개변수로 전달해줘야한다. 
		Runnable r = new ThreadEx01_02();
		Thread t2 = new Thread(r);
		
		t1.start();
//		t1.start(); //에러 Exception in thread "main" java.lang.IllegalThreadStateException -> 한번 실행한 thread는 다시 start 할 수 없다.
		t2.start();
	}
	
}
