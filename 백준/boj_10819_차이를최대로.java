package net.acmicpc;

import java.util.Scanner;

public class boj_10819_차이를최대로 {
	static boolean[] visited;
	static int[] arr;
	static int[] lst;
	static int N, sum;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		lst = new int[N];
		arr = new int[N];
		visited = new boolean[N];
		sum = 0;

		for (int i = 0; i < N; i++) {
			lst[i] = scanner.nextInt();
		}
		nPr(0);
		System.out.println(sum);
	}

	public static void nPr(int cnt) {
		if (cnt == N) {
			int x = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				x += Math.abs(arr[i] - arr[i + 1]);
			}
			if (sum < x) {
				sum = x;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[cnt] = lst[i];
				nPr(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
