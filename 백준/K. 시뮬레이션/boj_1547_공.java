package net.acmicpc;

import java.util.Scanner;

public class boj_1547_공 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();

		int[] cup = new int[4];
		cup[1] = 1;
		for (int i = 0; i < M; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();

			int tmp = cup[start];
			cup[start] = cup[end];
			cup[end] = tmp;
		}

		for (int i = 0; i < cup.length; i++) {
			if (cup[i] == 1) {
				System.out.println(i);
			}
		}

	}
}
