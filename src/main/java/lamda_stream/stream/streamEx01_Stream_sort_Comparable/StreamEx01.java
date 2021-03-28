package lamda_stream.stream.streamEx01_Stream_sort_Comparable;

import java.util.Comparator;
import java.util.stream.Stream;


public class StreamEx01 {

	public static void main(String[] args) {
		Stream<Student> student_stream = Stream.of(
					new Student("이승민", 1, 100),
					new Student("임신진", 2, 200),
					new Student("김형준", 3, 300),
					new Student("박신영", 1, 150),
					new Student("이상성", 2, 200),
					new Student("최혜근", 3, 250),
					new Student("최유진", 1, 100),
					new Student("한상우", 2, 130),
					new Student("안느발", 3, 160)
				);
		
		student_stream.sorted(
				Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder())
				).forEach(System.out::println);
		
		
		
	}
	
	static class Student implements Comparable<Student> {
		String name;
		int ban;
		int totalScore;
		Student(String name, int ban, int totalScore){
			this.name = name;
			this.ban = ban;
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
		public int compareTo(Student s) {
			return s.totalScore - this.totalScore;
		}
	}
}
