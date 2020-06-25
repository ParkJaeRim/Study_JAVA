package net.acmicpc;

import java.util.HashSet;
import java.util.Scanner;

public class boj_5567_결혼식{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] map = new int[n][n];

		for (int i = 0; i < m; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			map[x - 1][y - 1] = map[y - 1][x - 1] = 1;
		}

		int start = 0;
		HashSet<Integer> friend = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (map[start][i] == 1) {
				friend.add(i);
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						friend.add(j);
					}
				}
			}
		}

		System.out.println(friend.size() - 1);
	}
}
