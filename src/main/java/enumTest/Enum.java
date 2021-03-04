package enumTest;

import java.util.ArrayList;
import java.util.List;

public class Enum {

	public enum Season {
		SPRING, SUMMER, FALL, WINTER
	}
	public static void main(String[] args) {
		
		String name = Season.SPRING.name();
		System.out.println(name);
		List<Season> list = new ArrayList<Enum.Season>();
		list.add(Season.SPRING);
//		list.add("SPRING"); // 에러
	}
	
}
