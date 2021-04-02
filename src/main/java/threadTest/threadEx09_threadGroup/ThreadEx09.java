package threadTest.threadEx09_threadGroup;

public class ThreadEx09 {

	public static void main(String[] args) {
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group01");
		ThreadGroup grp2 = new ThreadGroup("Group02");
		
		//ThreadGroup(ThreadGroup parent, String name)
		//이미 있는  쓰레드를 
	}
	
}
