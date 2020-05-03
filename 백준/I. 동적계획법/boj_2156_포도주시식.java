package net.acmicpc;

import java.util.Scanner;

public class boj_2156_포도주시식 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[] podo = new int[N];

		for (int i = 0; i < N; i++) {
			podo[i] = scanner.nextInt();
		}
		int[][] howMany = new int[N][2];

		howMany[0][0] = podo[0];
		howMany[0][1] = 0;

		if (N == 1) {
			System.out.println(podo[0]);
		} else {
			howMany[1][0] = podo[1];
			howMany[1][1] = podo[1] + howMany[0][0];

			if (N == 2) {
				System.out.println(howMany[1][1]);

			} else {
				for (int i = 2; i < N; i++) {
					int tmp = 0;
					for (int j = 0; j < i - 1; j++) {
						tmp = Math.max(tmp, Math.max(howMany[j][0], howMany[j][1]));
					}
					howMany[i][0] = tmp + podo[i];
					howMany[i][1] = howMany[i - 1][0] + podo[i];
				}

				int ans = Integer.MIN_VALUE;
				for (int i = 0; i < howMany.length; i++) {
					for (int j = 0; j < howMany[i].length; j++) {
						ans = ans < howMany[i][j] ? howMany[i][j] : ans;
					}
				}
				System.out.println(ans);
			}
		}
	}
}
