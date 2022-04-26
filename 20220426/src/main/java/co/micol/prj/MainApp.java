package co.micol.prj;

import co.micol.prj.listTest.MapTest;

public class MainApp {

	public static void main(String[] args) {
		//java project 시작 및 종료

//		ListTest list = new ListTest();	//인스턴스
//		list.listTest();	//메소드
//		
//		System.out.println("==========================");
//		
//		list.studentList();
		
//		System.out.println("==========================");
		
//		SetTest setTest = new SetTest();	//인스턴스 생성
//		setTest.setTest();		//메소드 실행	//Set은 순서대로 출력되지 않는다
		
//		System.out.println("==========================");
		
		MapTest mapTest = new MapTest();
		mapTest.mapTest();
		mapTest.studentMap();
		
	}

}
