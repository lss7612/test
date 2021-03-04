package threadTest.threadEx03;

public class ThreadEx03 {

	public static void main(String[] args) {
		ThreadEx_03_01 t1 = new ThreadEx_03_01();
		t1.run();
		System.out.println("가나다");
		
		//TheradEx02와 비교하면, 02예제는 start()를 이용해 쓰레드를 생성한 후 run을 호출했다면
		//이번 예제에서는 메인 쓰레드에서 단순히 run을 호출했다.
		//순서대로 호출하므로 2번 예제와 다르게
		//Exception을 먼저 호출 후 가나다를 출력한다.
		
		
		//결과
//		java.lang.Exception
//		가나다
	}
	
}
