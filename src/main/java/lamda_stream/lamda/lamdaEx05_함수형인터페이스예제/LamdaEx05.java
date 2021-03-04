package lamda_stream.lamda.lamdaEx05_함수형인터페이스예제;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaEx05 {

	public static void main(String[] args) {
		
		Supplier<Integer> s = () -> (int)((Math.random()*100)+1);
		Consumer<Integer> c = i -> System.out.print(i+",");
		Predicate<Integer> p = i -> i%2==0;
		Function<Integer, Integer> f = i -> i/10*10;
		
		List<Integer> list = new ArrayList<>();
		
		makeRandomList(s, list);
		System.out.println(list);
		
		printEventNumber(p, c, list);
		
		System.out.println(doSomething(f, list));
		
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		System.out.println("Make Random List");
		for(int i = 0; i < 10; i++) {
			list.add(s.get());
		}
	}
	
	static <T> void printEventNumber(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.println("Print Event Number");
		System.out.print("[");
		for(T i: list) if(p.test(i)) c.accept(i);
		System.out.println("]");
	
	}
	
	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		System.out.println("Do Something");
		List<T> newList = new ArrayList<T>();
		list.forEach(item -> newList.add(f.apply(item)));
		return newList;
	}
	
}
