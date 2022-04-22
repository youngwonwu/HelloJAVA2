package co.micol.prj.app;

import java.util.Arrays;

import co.micol.prj.SelectionSort;

public class MainApp {

	public static void main(String[] args) {
		
//		SelectionSort selectSort = new SelectionSort();	//인스턴스 생성
		
//		int data[] = {5, 1, 4, 3, 2};	//원본 데이터
//		for(int d : data) {
//			System.out.println(d);
//		}
//		System.out.println("==========================");
//		data = selectSort.sort(data);	//결과 데이터
//		for(int i=0; i<data.length; i++) {
//			System.out.println(data[i]);
//		}
		
		
//		//SelectionSort selectSort = new SelectionSort();	//인스턴스 생성
		
//		int data[] = {5, 1, 4, 3, 2};	//원본 데이터
//		for(int d : data) {
//			System.out.println(d);
//		}
//		System.out.println("==========================");
//		//data = selectSort.sort(data);	//결과 데이터
//		Arrays.sort(data);	//오름차순 정렬
//		for(int i=0; i<data.length; i++) {
//			System.out.println(data[i]);
//		}
		
		
		//메인에서 출력하지 않고 
		SelectionSort selectSort = new SelectionSort();	//인스턴스 생성
		int data[] = {5, 1, 4, 3, 2};	//원본 데이터
		selectSort.sort(data);	//결과 데이터
		Arrays.sort(data);	//오름차순 정렬
		
	}
}
