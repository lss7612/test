package threadTest.threadEx02;

public class ThreadEx02 {

	public static void main(String[] args) {
		ThreadEx02_01 t1 = new ThreadEx02_01();
		t1.start();
		System.out.println("가나다");
		
		//실행결과
		// 가나다
		// java.lang.Exception
		
		//start()를 먼저 실행했으나 가나다가 먼저 실행되었다.
		// 생성된 쓰레드에서 Exception을 처리하는 시간보다 가나다를 출력하는데 시간이 더 짧게 걸렸다.
		// 가나다를 처리한 후 main 쓰레드는 스택을 모두 비우고 종료되었으며,
		// t1 쓰레드는 남아서 Exception을 처리한 후 종료된다.
		// 이후 모든 쓰레드가 종료되었으므로 프로그램이 종료된다.
	}
	
}
