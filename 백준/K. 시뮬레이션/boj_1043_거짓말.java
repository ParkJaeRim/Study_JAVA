package net.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1043_거짓말 {
	static int N, M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> al;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		visited = new boolean[N + 1];

		M = scanner.nextInt();

		int KnowTrue = scanner.nextInt();
		for (int i = 0; i < KnowTrue; i++) {
			int knowPpl = scanner.nextInt();
			visited[knowPpl] = true;
		}

		al = new ArrayList<>();

		for (int i = 0; i < M + 1; i++) {
			al.add(new ArrayList<Integer>());
		}

		int cnt = 0;
		for (int i = 1; i <= M; i++) {
			boolean flag = false;
			int tmp = scanner.nextInt();

			for (int j = 0; j < tmp; j++) {
				int comePpl = scanner.nextInt();
				al.get(i).add(comePpl);

				if (visited[comePpl]) {
					flag = true;
				}
				if (flag) {
					ArrayList<Integer> lst = al.get(i);
					for (int k = 0; k < lst.size(); k++) {
						visited[lst.get(k)] = true;
					}
				}
			}
		}
		lie();
		int ans = 0;
		int eachCnt = M;
		for (int i = 0; i < al.size(); i++) {
			boolean result = false;
			ArrayList<Integer> fin = al.get(i);
			for (int j = 1; j < visited.length; j++) {
				if (visited[j] && fin.contains(j)) {
					result = true;
				}
			}
			if (result) {
				eachCnt--;
			}
		}
		System.out.println(eachCnt);
	}

	public static void lie() {
		boolean go = false;
		for (int i = 0; i < al.size(); i++) {
			ArrayList<Integer> check = al.get(i);
			for (int j = 0; j < visited.length; j++) {
				if (visited[j] && check.contains(j)) {
					for (int k = 0; k < check.size(); k++) {
						if (!visited[check.get(k)]) {
							go = true;
							visited[check.get(k)] = true;
						}
					}
				}
			}
		}
		if (go) {
			lie();
		}
	}
}
