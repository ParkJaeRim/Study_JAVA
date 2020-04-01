package net.acmicpc;

import java.util.Scanner;

public class boj_3985_롤케이크 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] lst = new int[N + 1];
		int expect = 0;
		int expectIdx = 0;
		int ppl = scanner.nextInt();
		int[] count = new int[ppl + 1];
		for (int i = 1; i <= ppl; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			if (expect < to - from + 1) {
				expect = to - from + 1;
				expectIdx = i;

			}
			for (int j = from; j <= to; j++) {
				if (lst[j] == 0) {
					lst[j] = i;
				}
			}
		}

		System.out.println(expectIdx);
		for (int i = 0; i < lst.length; i++) {
			if (lst[i] != 0) {
				count[lst[i]]++;
			}
		}
		int maxCount = 0;
		int maxIdx = 0;
		for (int i = 0; i < count.length; i++) {
			if (maxCount < count[i]) {
				maxCount = count[i];
				maxIdx = i;
			}
		}
		System.out.println(maxIdx);
	}
}
