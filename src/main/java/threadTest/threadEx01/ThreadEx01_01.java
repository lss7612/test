package threadTest.threadEx01;

public class ThreadEx01_01 extends Thread {
	public void run() {
		for(int i = 0 ; i < 5; i++) {
			System.out.println(getName());
		}
	}
}
