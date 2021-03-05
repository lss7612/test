package lamda_stream.stream.streamEx02_Stream_Filter_Map;

import java.io.File;
import java.util.stream.Stream;

public class StreamEx02 {

	public static void main(String[] args) {
		File[] arr = {
				new File("Ex1.java"),
				new File("Ex1.txt"),
				new File("Ex2.java"),
				new File("Ex2"),
				new File("Ex1.bak")
		};
		
		Stream<File> file_stream = Stream.of(arr);
		file_stream.map(File::getName)
			.filter(name -> name.indexOf('.')!=-1)
			.map(str -> str.substring(str.indexOf('.')+1))
			.map(String::toUpperCase)
			.distinct()
			.forEach(System.out::println);
		
	}
	
}
