package lamda_stream.lamda.lamdaEx01_함수형인터페이스정의;

public class LamdaEx01 {
	
	static void execute(Myfunction f) {
		f.run();
	}
	
	static Myfunction getMyFunction() {
		Myfunction f = () -> System.out.println("f3.run()");
		return f;
	}
	
	public static void main(String[] args) {
		
		Myfunction f1 = ()-> System.out.println("f1.run()");
		Myfunction f2 = new Myfunction() {
			@Override
			public void run() {
				System.out.println("f2.run()");
			}
		};
		Myfunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute(()->System.out.println("run()"));
		
	}
	
	
}
