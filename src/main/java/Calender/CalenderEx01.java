package Calender;

import java.util.Calendar;

public class CalenderEx01 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); //기본적으로 현재 날짜와 시간으로 선택된다.
		System.out.println("올해 : " + cal.get(Calendar.YEAR));
		System.out.println("월(0부터 11까지) : " + cal.get(Calendar.MONTH));
		System.out.println("이 해의 몇째 주 ? : " + cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇째 주 ? : " + cal.get(Calendar.WEEK_OF_MONTH));
		
		System.out.println("이 달의 몇 일 ? : " + cal.get(Calendar.DATE));
		System.out.println("이 달의 몇 일 ? : " + cal.get(Calendar.DAY_OF_MONTH)); //DATE와 DAY OF MONTH는 같다
		System.out.println("이 해의 몇 일 ? : " + cal.get(Calendar.DAY_OF_YEAR));
		
		System.out.println("요일 (1~7) 1: 일요일 : " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("오전 오후 (1:오전, 2:오후) : " + cal.get(Calendar.AM_PM));
		
		System.out.println("시간 (0~11): " + cal.get(Calendar.HOUR));
		System.out.println("시간 (0~23): " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 (0~59)" + cal.get(Calendar.MINUTE));
		System.out.println("초 (0~59)" + cal.get(Calendar.SECOND));
		System.out.println("밀리세컨드 (1000분의 1초) 0~999" + Calendar.MILLISECOND);
		
		
		
		
		
	}
	
}
