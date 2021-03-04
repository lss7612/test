package lamda_stream.lamda.lamdaEx04_컬렉션프레임웍_함수형인터페이스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LamdaEx04 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) list.add(i);
		printList(list);
		
		list.removeIf(item->(item%2==0||item%3==0));
		printList(list);
		
		list.replaceAll(item->item*10);
		printList(list);
		
		Map<String,String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		map.forEach((key,value)->System.out.print("{"+key+","+value+"} "));
		
	}
	
	public static void printList(List<Integer> list) {
		list.forEach(item->System.out.print(item+","));
		System.out.println();
	};
	
}
