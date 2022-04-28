package test;

//import java.sql.Date;
import java.util.Date;
import java.util.Random;

public class StringExample {
	public static void main(String[] args) {
		
		//a와 b는 같은 주소값
		String a = "1";
		String b = "1";
		
		//c와 d는 다른 주소값
		String c = new String("1");
		String d = new String("1");
		
		a = a + b;
		
		StringBuilder sb = new StringBuilder();
		sb.append("a");			//append 
		sb.append("b");
		sb.append("c");
		System.out.println(sb.toString());
		
		String exam = "1, 2, 3, 4, 5, 6, 7";
		exam.split(",");	//split : 문자열을 쪼갠다, 배열타입으로 받아서 실행한다
		String[] tmep = exam.split(",");
		
		Random rd = new Random();
		rd.setSeed(0);	//Long타입 데이터값을 넣는다
		long time = System.currentTimeMillis();		//시간구하는 함수
		long time2 = System.nanoTime();				//시간구하는 함수
		System.out.println((rd.nextInt()*45) + 1);
		System.out.println(time);
		System.out.println(time2);
		
		
		
		//---------------------------------------------------
		
		
		Date date = new Date(0);		//java.sql.Date 년, 월, 일, 시, 분 출력됨
		
		Date date2 =new Date();			//java.util.Date 초까지 나온다?9
		
		
		
	}

}
