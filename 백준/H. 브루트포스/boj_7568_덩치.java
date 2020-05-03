package net.acmicpc;

import java.util.Scanner;

public class boj_7568_덩치 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[] height = new int[N];
		int[] weight = new int[N];
		int[] ppl = new int[N];
		for (int i = 0; i < N; i++) {
			height[i] = scanner.nextInt();
			weight[i] = scanner.nextInt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					if (height[i] < height[j] && weight[i] < weight[j]) {
						ppl[i]++;
					}
				}
			}
		}
		for (int i = 0; i < ppl.length; i++) {
			System.out.print((ppl[i]+1)+" ");
		}
	}
}
