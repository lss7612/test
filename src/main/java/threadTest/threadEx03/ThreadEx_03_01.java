package threadTest.threadEx03;

public class ThreadEx_03_01 extends Thread{

	@Override
	public void run() {
		throwException();
	}

	private void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
