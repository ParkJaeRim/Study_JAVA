package net.acmicpc;

import java.util.Scanner;

public class Solution_D3_1208 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = 10;
		int len = 100;
		for (int tc = 1; tc <= T; tc++) {
			int[] lst = new int[len];

			int N = scanner.nextInt();
			int max_idx = 0;
			int min_idx = 0;

			for (int i = 0; i < len; i++) {
				lst[i] = scanner.nextInt();
			}

			while (N != 0) {
				int maxValue = lst[0];
				int minValue = lst[0];
				for (int i = 0; i < lst.length; i++) {
					if (lst[i] > maxValue) {
						maxValue = lst[i];
					}
				}

				for (int j = 0; j < lst.length; j++) {
					if (lst[j] < minValue) {
						minValue = lst[j];
					}
				}
//					System.out.println(max_idx + " " + min_idx);
				for (int k = 0; k < lst.length; k++) {
					if(lst[k]== minValue) {
						min_idx = k;
					}
					if(lst[k]== maxValue) {
						max_idx = k;
					}
				}
				lst[max_idx] -= 1;
				lst[min_idx] += 1;
				N--;
			}

			int maxValue = lst[0];
			int minValue = lst[0];
			for (int i = 0; i < lst.length; i++) {
				if (lst[i] > maxValue) {
					maxValue = lst[i];

				}
			}
			for (int j = 0; j < lst.length; j++) {
				if (lst[j] < minValue) {
					minValue = lst[j];
				}

			}
			System.out.println("#" + tc + " " + (maxValue - minValue));
		}

	}
}
