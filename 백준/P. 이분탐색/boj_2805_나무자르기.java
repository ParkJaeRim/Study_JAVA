package net.acmicpc;

import java.util.Scanner;

public class boj_2805_나무자르기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		long M = scanner.nextInt();

		int[] tree = new int[N];
		long sum = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = scanner.nextInt();
			sum += tree[i];
		}
		long maxV = Long.MIN_VALUE;
		long start = 0;
		long end = sum;
		long mid = 0;
		long cut = Long.MAX_VALUE;
		long invalid = Long.MIN_VALUE;
		boolean proper = false;

		while (start < end) {
			mid = (start + end) / 2;
//			System.out.println(start + " " + mid + "  " + end);
			long tot = 0;

			for (int i = 0; i < tree.length; i++) {
				if (tree[i] - mid >= 0) {
					tot += tree[i] - mid;
				}
			}

			if (tot > M) {
				start = (start + end) / 2 + 1;
				if (cut > tot) {
					cut = tot;
					invalid = mid;

				}
			} else if (tot < M) {
				end = (start + end) / 2;
			} else {
				maxV = Math.max(maxV, mid);
				proper = true;
				break;
			}
		}
		if (proper) {
			System.out.println(maxV);
		} else {
			System.out.println(invalid);
//			System.out.println(maxV + " " + invalid);
		}
	}

}
