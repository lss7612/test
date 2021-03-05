package lamda_stream.stream.streamEx05_terminal_operation;

import java.util.stream.Stream;

public class StreamEx05_forEach {

	public static void main(String[] args) {
		String[] strArr = {
				"가나다","라마바","사아자","차카하","도레미","파솔라"
		};
		
		Stream.of(strArr).map(str->str+=",").forEach(System.out::print);
		
	}
	
}
