package co.micol.prj.game;

import java.util.Scanner;

public class Mabangjin {

	private Scanner sc = new Scanner(System.in);

	public void run() {
		System.out.println("*** 마방진 게임시작합니다.");
		System.out.println("홀수만 입력하세요.");
		mabangjin();
	}

	private void mabangjin() {
		int size = sc.nextInt();
		int[][] arr = new int[size][size];
		int num = 1;
		System.out.println(size + " * " + size + "마방진");
		for (int i = 0, j = size / 2; num <= size * size; num++) {
			arr[i][j] = num;
			if (num % size == 0) {
				i++;
			} else {
				i--;
				j++;
				if (i < 0)
					i = size - 1;
				if (j > size - 1)
					j = 0;
			}
		}
		// 출력 호출
		toPrint(arr);

	}

	public void toPrint(int[][] result) {
		for (int[] num : result) {
			for (int n : num) {
				System.out.printf("%4d", n);
			}
			System.out.println();
		}
	}

}
