package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2294_동전2 {
	static int N, v;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
		}
		int[] won = new int[N];
		int[][] count = new int[N][v + 1];

			for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
				won[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(won);
		for (int i = 0; i < v + 1; i++) {
			if (i % won[0] == 0) {
				count[0][i] = i / won[0];
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < v + 1; j++) {
				if (j - won[i] < 0) {
					count[i][j] = count[i - 1][j];
				}

				else if (j - won[i] == 0) {
					count[i][j] = 1;
				}

				else if (j - won[i] > 0) {
					if (count[i][j - won[i]] == 0 && count[i - 1][j] != 0) {
						count[i][j] = count[i - 1][j];
					} else if (count[i][j - won[i]] != 0 && count[i - 1][j] != 0) {
						count[i][j] = Math.min(count[i][j - won[i]] + 1, count[i - 1][j]);
					} else if (count[i - 1][j] == 0 && count[i][j - won[i]] != 0) {
						count[i][j] = count[i][j - won[i]] + 1;
					}

				}
			}
		}
		if (count[N - 1][v] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(count[N - 1][v]);
		}
	}

	public static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
