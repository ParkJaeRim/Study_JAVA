package net.acmicpc;

import java.util.Scanner;

public class boj_10872_팩토리얼 {
	static int result;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		result = 1;
		if (N == 0) {
			System.out.println(1);
		} else {
			factorial(N);
			System.out.println(result);

		}
	}

	public static void factorial(int x) {
		if (x == 0) {
			return;
		} else {
			result *= x;
			factorial(x - 1);

		}
	}
}
