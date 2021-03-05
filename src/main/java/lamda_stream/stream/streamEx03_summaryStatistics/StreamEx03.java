package lamda_stream.stream.streamEx03_summaryStatistics;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx03 {

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
		
		Stream<Student> stuStream = Stream.of(arr);
		stuStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
		
		stuStream = Stream.of(arr);
		IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		System.out.println(stat);
		
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
