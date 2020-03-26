package net.acmicpc;

import java.util.Scanner;

public class boj_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int ans = 0;

		int i = N / 5;
		if (N < 5) {
			if (N == 3) {
				ans = 1;
			} else {
				ans = -1;
			}

		} else {
			while (i>0) {
				if (N % (i * 5) == 0) {
					ans = N / 5;
					break;
				} else if ((N - (5 * i)) % 3 == 0) {
					ans = i;
					N = N - (5 * i);
					ans += N / 3;
					break;
				} else if (N % 3 == 0) {
					ans = N / 3;
				} else {
					ans = -1;
				}
				i--;
			}
		}
		System.out.println(ans);
	}
}
