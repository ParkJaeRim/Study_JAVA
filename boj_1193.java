package net.acmicpc;

import java.util.Scanner;

public class boj_1193 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int MAX = 0;
		int i = 0;

		while (MAX < N) {
			i++;
			MAX = (i * i + i) / 2;

		}

		int cal = MAX - N;
		if (i % 2 == 0) {
			System.out.println((i - cal) + "/" + (1 + cal));
		} else {
			System.out.println((1 + cal) + "/" + (i - cal));
		}
	}
}
