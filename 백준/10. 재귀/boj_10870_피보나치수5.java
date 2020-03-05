package net.acmicpc;

import java.util.Scanner;

public class boj_10870_피보나치수5 {
	static int N;
	static int[] lst;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		lst = new int[N + 1];
		lst[0] = 0;
		if (N == 0) {
			System.out.println(0);
		} else if (N == 1) {
			lst[1] = 1;
			System.out.println(1);
		} else {
			lst[1] = 1;
			fibo(2);
		}

	}

	public static void fibo(int x) {
		if (x == N) {
			lst[x] = lst[x - 1] + lst[x - 2];
			System.out.println(lst[N]);
			return;
		}
		lst[x] = lst[x - 1] + lst[x - 2];
		fibo(x + 1);
	}
}
