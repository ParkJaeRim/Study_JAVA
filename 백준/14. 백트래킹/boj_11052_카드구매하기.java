package net.acmicpc;

import java.util.Scanner;

public class boj_11052_카드구매하기 {
	static int[] d;
	static int[] card;
	static int N;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		card = new int[N + 1];
		d = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			card[i] = scanner.nextInt();
		}

		d[1] = card[1];

		for (int i = 2; i < N + 1; i++) {
			int tmp = Integer.MAX_VALUE;
			for (int j = 1; j < i; j++) {
				if (tmp > d[i - j] + d[j]) {
					tmp = d[i - j] + d[j];
//					System.out.println(tmp);
				}
				d[i] = Math.min(card[i], tmp);
			}
		}
		
		System.out.println(d[N]);
	}
}
