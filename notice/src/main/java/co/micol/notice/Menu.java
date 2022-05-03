package co.micol.notice;

import java.util.Scanner;

public class Menu {
	
	////8
	private Scanner sc = new Scanner(System.in);
	
	private void menuTitle() {
		System.out.println("==========================");
		System.out.println("==1.학생관리 2.공지사항 3.종료==");
		System.out.println("============================");
	}
	
	private void studentTitle() {
		System.out.println("==========================================================");
		System.out.println("==1.전체학생목록 2.학생정보조회 3.학생정보등록 4.학생정보수정 5.학생정보삭제==");
		System.out.println("==========================================================");
	}
	
	private void noticeTitle() {
		System.out.println("==========================================================");
		System.out.println("==1.공지사항목록 2.공지사항조회 3.공지사항등록 4.공지사항수정 5.공지사항삭제==");
		System.out.println("==========================================================");
	}
	
	private void mainMenu() {
		menuTitle();
		System.out.print("메뉴를 고르세요>> ");
		int menut = sc.nextInt();
		
		switch(menut) {
		case 1:
			studentTitle();
			System.out.print("메뉴를 고르세요>> ");
			int menus = sc.nextInt();
			
			if(menus == 1) {
				
			} else if(menus == 2) {
				
			} else if(menus == 3) {
				System.out.println("==3.학생정보등록==");
				System.out.println("학생 번호를 입력하세요");
				int stId = sc.nextInt();
				System.out.println("학생 이름을 입력하세요");
				String sname = sc.nextLine();
				System.out.println("학생 생년월일을 입력하세요");
				String sbirth = sc.nextLine();
				System.out.println("학생 전공을 입력하세요");
				String smajor = sc.nextLine();
				System.out.println("학생 주소를 입력하세요");
				String saddr = sc.nextLine();
				System.out.println("학생 번호을 입력하세요");
				String stel = sc.nextLine();
				
				
				
			} else if(menus == 4) {
				
			}
			break;
		case 2:
			noticeTitle();
			break;
		case 3:
			System.out.println("end of prog.");
			break;
		}
	}
	
	
	
	
}
