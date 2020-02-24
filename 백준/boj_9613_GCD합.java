package net.acmicpc;

import java.util.Scanner;

public class boj_9613_GCD합 {
	static int A, B;
	static long sum;
	static int[] lst;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int tc = 0; tc < T; tc++) {
			
			int N = scanner.nextInt();
			lst = new int[N];
			for (int i = 0; i < N; i++) {
				lst[i] = scanner.nextInt();
			}
			sum = 0L;
			for (int m = 0; m < lst.length - 1; m++) {
				for (int n = m+1; n < lst.length; n++) {
					GCD(lst[m],lst[n]);
				}
			}
			System.out.println(sum);
		}
	}

	private static void GCD(int a, int b) {
		if (a == 0) {
			sum += b;
			return;
		}
		if (b == 0) {
			sum += a;
			return;
		}
		if (b != 0 && a > b) {
			GCD(a % b, b);
		}
		if (a!=  0 &&  a <= b) {
			GCD(a, b % a);
		}
	}
}
