package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1654_랜선자르기{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int max = scanner.nextInt();
		long sum = 0;
		int[] lst = new int[N];
		for (int i = 0; i < N; i++) {
			lst[i] = scanner.nextInt();
			sum += lst[i];
		}
		Arrays.sort(lst);

		long start = 1;
		long end = sum / N;
		long tot = 0;
		long mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			tot = 0;

			for (int i = 0; i < N; i++) {
				tot += lst[i] / mid;
			}
			if (tot >= max) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}
}
