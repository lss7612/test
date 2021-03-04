package lamda_stream.lamda.lamdaEx03_람다와지역변수;


interface MyFunction {
	void myMethod();
}

class Outer {
	
	int val = 10; //Outer.this.val
	
	class Inner {
		
		int val = 20; //Inner.this.val
		
		void method(int i) {
			int val = 30;
			//람다식 내부에서 참조하고 있는 지역변수 i는 final이 붙지 않아도 상수로 간주된다.
			//아래 람다식 내부에서 참조하는 중에는 아래에서 i=10에서 오류가 난다.
			//하지만 람다식에서 참조하지 않으면 문제 없는 코드다.
			
//			i = 10; //에러 상수의 값을 변경할 수 없음
			
			MyFunction f = ()->{
				System.out.println("i : " + i);
				System.out.println("val : " + val);
				System.out.println("this.val : " + this.val);
				System.out.println("Outer.this.val : " + Outer.this.val);
			};
			f.myMethod();
		}
		
	}//Inner End
	
}//Outer End

public class LamdaEx03 {
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}
	
}
