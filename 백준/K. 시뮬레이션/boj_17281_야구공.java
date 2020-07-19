package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17281_야구공 {
	static int[] sequence;
	static int goal, game, ans, out, inning;
	static int[][] score;

	static boolean[] visited, taseok;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		sequence = new int[9];
		sequence[3] = 0;
		goal = Integer.parseInt(st.nextToken());
		score = new int[goal][9];

		visited = new boolean[9];

		ans = Integer.MIN_VALUE;
		taseok = new boolean[3];

		for (int i = 0; i < goal; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setSequence(0);
		System.out.println(ans);
	}

	public static void setSequence(int cnt) {
		if (cnt == 3) {
			setSequence(cnt + 1);
			return;
		}
		if (cnt == 9) {
			game = 0;
			out = 0;
			inning = 0;

			play();
			ans = Math.max(ans, game);
			return;
		}

		for (int i = 1; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sequence[cnt] = i;
				setSequence(cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static void play() {
		int i = 0;
		while (inning != goal) {
			if (score[inning][sequence[i]] != 0) {
				if (score[inning][sequence[i]] == 1) {
					if (taseok[2]) {
						game++;
					}
					for (int j = taseok.length - 2; j >= 0; j--) {
						taseok[j + 1] = taseok[j];
					}
					taseok[0] = true;

				} else if (score[inning][sequence[i]] == 2) {
					if (taseok[2]) {
						game++;

					}
					if (taseok[1]) {
						game++;
					}
					taseok[2] = taseok[0];
					taseok[1] = true;
					taseok[0] = false;

				} else if (score[inning][sequence[i]] == 3) {
					for (int j = 0; j < taseok.length; j++) {
						if (taseok[j]) {
							game++;
						}
						taseok[j] = false;
					}
					taseok[2] = true;

				} else if (score[inning][sequence[i]] == 4) {
					for (int j = 0; j < taseok.length; j++) {
						if (taseok[j]) {
							game++;
						}
						taseok[j] = false;
					}
					game++;
				}
			}

			else {
				out++;
				if (out == 3) {
					out = 0;
					taseok = new boolean[3];

					inning++;
					if (inning == goal) {
						return;
					}
				}
			}
			i++;
			if (i >= 9) {
				i = 0;
			}
		}
	}
}
