package threadTest.threadEx01;

public class ThreadEx01_02 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			//Thread.currentThread(); -> 현재 실행중인 Thread의 이름을 반환한다.
			System.out.println(Thread.currentThread().getName());
			
			//위 코드는 아래 3줄의 코드와 같다.
			
//			Thread t = Thread.currentThread();
//			String name = t.getName();
//			System.out.println(name);
		}
	}
	
}
