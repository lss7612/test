package lamda_stream.stream.streamEx05_terminal_operation;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx06_Collectors {

	public static void main(String[] args) {
		Student[] arr = {
				new Student("이승민", 1, 100),
				new Student("임신진", 2, 200),
				new Student("김형준", 3, 300),
				new Student("박신영", 1, 150),
				new Student("이상성", 2, 200),
				new Student("최혜근", 3, 250),
				new Student("최유진", 1, 100),
				new Student("한상우", 2, 130),
				new Student("안느발", 3, 160)
		};
		
		// 이름만 받아서 리스트 만들기
		List<String> nameList = Stream.of(arr).map(Student::getName).collect(Collectors.toList());
		System.out.println(nameList);
		System.out.println();
		
		// 스트림을 다시 배열로 바꿔서 출력해보기
		Student[] stuArr2 = Stream.of(arr).toArray(Student[]::new);
		for(Student stu : stuArr2) System.out.println(stu);
		
		//스트림을 맵으로 컬렉트
		Map<String, Object> stuMap = Stream.of(arr).collect(Collectors.toMap(stu->stu.getName(), p->p));
		for(String key : stuMap.keySet()) System.out.println("key : "+key+" , value : " + stuMap.get(key));
		
		//counting();
		long count = Stream.of(arr).collect(Collectors.counting());
		System.out.println(count);
		
		//summingInt
		long totalSum = Stream.of(arr).collect(Collectors.summingInt(Student::getTotalScore));
		System.out.println(totalSum);
		
		//reducing
		totalSum = Stream.of(arr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		System.out.println(totalSum);
		
		//totalScore이용하여 최대값 구하기
		Optional<Student> topStudent = Stream.of(arr).collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
		System.out.println(topStudent.get());
		
		// summarizingInt IntSummaryStatistics Summary 얻어오기 
		IntSummaryStatistics stat = Stream.of(arr).collect(Collectors.summarizingInt(Student::getTotalScore));
		System.out.println(stat);

		
		//joining 두번쨰 인자와 세번쨰 인자는 맨 앞과 맨 뒤에 붙을 문자열을 세팅한다.
		String stuNames = Stream.of(arr).map(Student::getName).collect(Collectors.joining(",","{","}"));
		System.out.println(stuNames);
	}
	
	
	static class Student implements Comparable<Student>{

		String name;
		int ban;
		int totalScore;
		
		Student(String name, int ban, int totalScore){
			this.ban = ban;
			this.name = name;
			this.totalScore = totalScore;
		}
		public String toString() {
			return String.format("'%s','%d','%d'", name,ban,totalScore);
		}
		public String getName() {
			return name;
		}
		public int getBan() {
			return ban;
		}
		public int getTotalScore() {
			return totalScore;
		}
		@Override
		public int compareTo(Student o) {
			return o.totalScore - totalScore;
		}
	}
}
