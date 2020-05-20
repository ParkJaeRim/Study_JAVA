package net.acmicpc;

import java.util.Scanner;

public class boj_1065_한수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		int ans = 0;
		while (N != 0) {
			if (N / 100 >= 1) {
				int baek = N / 100;
				int sib = (N - (baek * 100)) / 10;
				int il = N % 10;
				if ((baek - sib) == (sib - il)) {
					ans++;
				}
			} else if (N < 100) {
				ans++;
			}
			N--;
		}
		System.out.println(ans);

	}
}
