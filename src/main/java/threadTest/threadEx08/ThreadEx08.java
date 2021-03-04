package threadTest.threadEx08;

public class ThreadEx08 {

	public static void main(String[] args) {
		ThreadEx08_01 t1 = new ThreadEx08_01();
		ThreadEx08_02 t2 = new ThreadEx08_02();
		
		t2.setPriority(7);
		
		System.out.println("t1.getPriority() - : " + t1.getPriority());
		System.out.println("t2.getPriority() | : " + t2.getPriority());
		
		t1.start();
		t2.start();
	}
	
}
