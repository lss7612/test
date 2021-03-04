package threadTest.threadEx05_multiThread;

public class ThreadEx05 {

	static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) {
		
		ThreadEx05_01 t1 = new ThreadEx05_01();
		t1.start();
		
		for(int i = 0; i < 1000; i++) {
			System.out.printf("%s",new String("-"));
			if(i%100==0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("소요시간1: " + (System.currentTimeMillis()-startTime));
	}
	
}
