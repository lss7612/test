package threadTest.threadEx05_multiThread;

public class ThreadEx05_01 extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.printf("%s",new String("|"));
			if(i%100==0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.print("소요시간2: " + (System.currentTimeMillis()-ThreadEx05.startTime));
	}
}
