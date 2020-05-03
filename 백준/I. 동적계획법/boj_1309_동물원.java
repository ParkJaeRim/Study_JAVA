package net.acmicpc;

import java.util.Scanner;

public class boj_1309_동물원 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		long[][] map = new long[N + 1][3];

		for (int i = 0; i < 3; i++) {
			map[1][i] = 1;
		}

		for (int i = 2; i < N + 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					map[i][j] = (map[i - 1][0] + map[i - 1][1] + map[i - 1][2]) % 9901;
				} else if (j == 1) {
					map[i][j] = (map[i - 1][0] + map[i - 1][2]) % 9901;
				} else if (j == 2) {
					map[i][j] = (map[i - 1][0] + map[i - 1][1]) % 9901;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < 3; i++) {
			ans += map[N][i];
		}
		System.out.println(ans % 9901);
	}
}
