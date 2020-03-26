package net.acmicpc;

import java.util.Scanner;

public class boj_1699_제곱수의합 {
	static int[] arr;
	static int N;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		arr = new int[N + 1];
		arr[1] = 1;

		for (int i = 2; i < arr.length; i++) {
			arr[i] = i;
			for (int j = 1; j * j <= i; j++) {
				arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
			}
		}
		System.out.println(arr[N]);
	}
}
