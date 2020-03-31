package net.acmicpc;

import java.util.Scanner;

public class boj_2979_트럭주차 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int one = scanner.nextInt();
		int two = scanner.nextInt();
		int three = scanner.nextInt();

		int[] lst = new int[101];
		for (int i = 0; i < 3; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			for (int j = start; j < end; j++) {
				lst[j]++;
			}
		}

		int cost = 0;
		for (int i = 0; i < lst.length; i++) {
			if (lst[i] == 1) {
				cost += one;
			}
			if (lst[i] == 2) {
				cost += (two * 2);
			}
			if (lst[i] == 3) {
				cost += (three * 3);
			}
		}
		System.out.println(cost);

	}
}
