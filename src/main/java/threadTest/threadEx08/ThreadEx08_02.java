package threadTest.threadEx08;

public class ThreadEx08_02 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
			if(i%100==0) System.out.println();
			for(int x = 0; x<10000000; x++);
		}
	}
}
