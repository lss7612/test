package threadTest.threadEx04_singleThread;

public class ThreadEx04_singleThread {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			System.out.printf("%s",new String("-"));
			if(i%100==0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("소요시간1: " + (System.currentTimeMillis()-startTime));
		
		for(int i = 0; i < 1000; i++) {
			System.out.printf("%s",new String("|"));
			if(i%100==0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.print("소요시간2: " + (System.currentTimeMillis()-startTime));
	
	}
}
