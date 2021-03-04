package lamda_stream.lamda.lamdaEx07_Function의합성_Predicate결합;

import java.util.function.Function;
import java.util.function.Predicate;

public class LamdaEx07 {

	public static void main(String[] args) {
		Function<String, Integer> makeInt16 = str -> Integer.parseInt(str,16);
		Function<Integer, String> makeBinaryStr = num -> Integer.toBinaryString(num);
		
		Function<String, String> func01 =  makeInt16.andThen(makeBinaryStr);
		Function<Integer, Integer> func02 =  makeInt16.compose(makeBinaryStr);
		System.out.println(func01.apply("FF"));
		System.out.println(func02.apply(2));
		
		Function<String,String> identify = Function.identity();
		System.out.println(identify.apply("AAA"));
		
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i % 2 == 0;
		Predicate<Integer> notP = p.negate();
		
		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150));
		
		String str1 = "abc";
		Predicate<String> p2 = Predicate.isEqual(str1);
		System.out.println(p2.test("abc"));
		System.out.println(p2.test("aBc"));
	}
	
}
