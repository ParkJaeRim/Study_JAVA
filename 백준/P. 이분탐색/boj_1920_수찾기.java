package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1920_수찾기{
	static int[] check;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		check = new int[N];
		for (int i = 0; i < N; i++) {
			check[i] = scanner.nextInt();
		}

		Arrays.sort(check);
		int M = scanner.nextInt();
		for (int i = 0; i < M; i++) {
			if (find(scanner.nextInt())) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
			System.out.print(" ");
		}
	}

	public static boolean find(int m) {
		int start = 0;
		int end = check.length;
		int mid = (start + end) / 2;

		if (m > check[mid]) {
			start = mid;
			mid = (start + end / 2);
		} else if (m < check[mid]) {
			end = mid;
			mid = (start + end) / 2;
		}

		for (int i = start; i < end; i++) {
			if (check[i] == m) {
				return true;
			}
		}
		return false;

	}
}
