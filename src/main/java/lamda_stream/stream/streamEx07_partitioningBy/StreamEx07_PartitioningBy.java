package lamda_stream.stream.streamEx07_partitioningBy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
	String name;
	boolean isMale;
	int grade;
	int ban;
	int score;
	
	Student(String name, boolean isMail, int grade, int ban, int score){
		this.name = name;
		this.isMale = isMail;
		this.grade = grade;
		this.ban = ban;
		this.score = score;
	}

	public String toString() {
		return String.format("[%s, %s, %d학년 %d반, %3d점]", name,isMale ? "남" : "여", grade,ban,score);
	}
	
	public String getName() {
		return name;
	}

	public boolean isMale() {
		return isMale;
	}

	public int getGrade() {
		return grade;
	}

	public int getBan() {
		return ban;
	}

	public int getScore() {
		return score;
	}

}

public class StreamEx07_PartitioningBy {
	
	public static void main(String[] args) {
		
		Student[] arr = {
				new Student("이승민", true,1,1, 100),
				new Student("임신진", true,1,1, 200),
				new Student("김형준", true,1,1, 300),
				new Student("박신영", false,1,2, 150),
				new Student("이상성", true,1,2, 200),
				new Student("최혜근", false,1,2, 250),
				new Student("최유진", false,1,3, 100),
				new Student("한상우", true,1,3, 130),
				new Student("안느발", true,1,3, 160),
				
				new Student("이승민", true,2,1, 100),
				new Student("임신진", true,2,1, 200),
				new Student("김형준", true,2,1, 300),
				new Student("박신영", false,2,2, 150),
				new Student("이상성", true,2,2, 200),
				new Student("최혜근", false,2,2, 250),
				new Student("최유진", false,2,3, 100),
				new Student("한상우", true,2,3, 130),
				new Student("안느발", true,2,3, 160)
		};
		
		//성별로 분할
		System.out.println("단순 성별로 분할");
		Map<Boolean, List<Student>> stuByGender = Stream.of(arr).collect(Collectors.partitioningBy(Student::isMale));
		System.out.println(stuByGender.get(true));
		System.out.println(stuByGender.get(false));
		System.out.println();
		
		//성별 별 학생 수
		System.out.println("성별 당 학생 수 ");
		Map<Boolean, Long> stuCntByGender = Stream.of(arr).collect(Collectors.partitioningBy(Student::isMale, Collectors.counting()));
		System.out.println("남자 : " + stuCntByGender.get(true));
		System.out.println("여자 : " + stuCntByGender.get(false));
		System.out.println();
		
		//성별 별 1등
		System.out.println("성별 별 1등");
		Map<Boolean, Optional<Student>> bestStuByGender = Stream.of(arr).collect(
				Collectors.partitioningBy(
						Student::isMale , Collectors.maxBy(
								Comparator.comparingInt(Student::getScore)
								)
						)
				);
		System.out.println("남자 1등 : " + bestStuByGender.get(true).get());
		System.out.println("여자 1등 : " + bestStuByGender.get(false).get());
		System.out.println();
		
		Map<Boolean,Student> bestStuByGender2 = Stream.of(arr).collect(
					Collectors.partitioningBy(
							Student::isMale,Collectors.collectingAndThen(Collectors.maxBy(
									Comparator.comparingInt(Student::getScore)), Optional::get))
					);
		System.out.println("남자 1등 : " + bestStuByGender2.get(true));
		System.out.println("여자 1등 : " + bestStuByGender2.get(false));
		System.out.println();
		
		//150점 이상 이하로 성별 분할
		Map<Boolean, Map<Boolean,List<Student>>> failStuByGender = Stream.of(arr).collect(
				Collectors.partitioningBy(Student::isMale,
				Collectors.partitioningBy(stu -> stu.getScore()<150)
				));
		
		System.out.println(
				"남자 탈락자들 : " + failStuByGender.get(true) //남자
													.get(true) //150이하
				);
		System.out.println(
				"여자 탈락자들 : " + failStuByGender.get(false) //여자
													.get(true) //150이하
				);
	}
	
	
}
