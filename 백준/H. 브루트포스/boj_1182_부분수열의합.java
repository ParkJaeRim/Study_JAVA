package net.acmicpc;

import java.util.Scanner;

public class boj_1182_부분수열의합 {
	static int N, tot, ans;
	static int[] num, arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		tot = scanner.nextInt();
		num = new int[N];
		arr = new int[N];

		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			num[i] = scanner.nextInt();
		}
		ans = 0;
		find(0, 0, 0);
		System.out.println(ans);
	}

	public static void find(int start, int cnt, int sum) {
		if (cnt != 0 && cnt <= N) {
			if (sum == tot) {
				ans++;
			}
		}
		if (cnt > N) {
			return;
		}

		for (int i = start; i < N; i++) {
			arr[cnt] = num[i];
			visited[i] = true;
			find(i + 1, cnt + 1, sum + num[i]);
			visited[i] = false;
		}

	}
}
