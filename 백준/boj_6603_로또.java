package net.acmicpc;

import java.util.Scanner;

public class boj_6603_로또 {
	static int N, R;
	static int[] num;
	static int[] LottoNum;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;

		while (!flag) {
			N = scanner.nextInt();
			if (N == 0) {
				break;
			}
			R = 6;
			num = new int[N];
			LottoNum = new int[R];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				num[i] = scanner.nextInt();
			}
			lotto(0, 0);
			System.out.println();
		}
	}

	public static void lotto(int start, int cnt) {
		if (cnt == R) {
			for (int i = 0; i < LottoNum.length; i++) {
				System.out.print(LottoNum[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			LottoNum[cnt] = num[i];
			lotto(i + 1, cnt + 1);
		}
	}
}
