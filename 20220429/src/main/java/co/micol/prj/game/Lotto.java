package co.micol.prj.game;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
	// 돈을 넣었을때
	// 로또 몇개
	// 자동 동수

	public void run() {
		System.out.println("로또게임");
		lotto();
	}

	Scanner sc = new Scanner(System.in);
	int[] lottoNums = new int[6];
	int[] myNums = new int[6];
	int temp;
	int money;
	int menu;

	public void lotto() {
		System.out.println("몇 개의 로또를 사시겠습니까? 로또 한줄에 천원입니다.");
		money = sc.nextInt();
		int set = money / 1000;
		System.out.println("1.자동 2. 수동");
		menu = sc.nextInt();
		
		//System.out.println("잔액이 부족합니다.");
		
		//System.out.println("거스름돈 드릴께요");

		if(menu == 1) {
			while (set > 0) {
				for (int i = 'A'; i <= 'E'; i++) {
					System.out.println((char) i + " 자 동 ");

					for (int j = 0; j < myNums.length; j++) {
						temp = (int) (Math.random() * 45) + 1;

						// 중복값 제거
						for (int k = 0; k < j; k++) {
							if (myNums[j] == temp) {
								i--;
								break;
							}
						}
					}
					Arrays.sort(myNums); // 오름차순으로 정렬
					//번호 출력
					for (int l = 0; l < myNums.length; l++) {
						temp = (int) (Math.random() * 45) + 1;
						temp = myNums[l];
						System.out.println("0" + temp + " ");
					}
				}
				set--;
			}
		}
		

	}

}
