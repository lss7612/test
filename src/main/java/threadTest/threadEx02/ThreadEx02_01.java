package threadTest.threadEx02;

public class ThreadEx02_01 extends Thread {

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
