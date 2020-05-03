package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_14499_주사위굴리기 {
	static int[] jusawi;
	static int[][] map;
	static int startY, startX;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		startX = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.hasMoreTokens()) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		ArrayList<Integer> al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			if (st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				al.add(x);
			}
		}

		jusawi = new int[6];
		StringBuilder sb = new StringBuilder();

		while (al.size() > 0) {
			int turn = al.get(0);
			boolean flag = false;
			if (turn == 1) {
				if (startX + 1 < M) {
					East();
					startX = startX + 1;
					copy();
				} else {
					flag = true;
				}
			} else if (turn == 2) {
				if (startX - 1 >= 0) {
					West();
					startX = startX - 1;
					copy();
				} else {
					flag = true;
				}
			} else if (turn == 3) {
				if (startY - 1 >= 0) {
					North();
					startY = startY - 1;
					copy();
				} else {
					flag = true;
				}
			} else {
				if (startY + 1 < N) {
					South();
					startY = startY + 1;
					copy();
				} else {
					flag = true;
				}
			}
			if (!flag) {
				sb.append(jusawi[0]).append("\n");
			}
			al.remove(0);
		}
		br.close();
		System.out.println(sb.substring(0, sb.length() - 1));
	}

	public static void copy() {
		if (map[startY][startX] == 0) {
			map[startY][startX] = jusawi[1];
		} else {
			jusawi[1] = map[startY][startX];
			map[startY][startX] = 0;
		}
	}

	public static void East() {
		int tmp = jusawi[0];
		jusawi[0] = jusawi[2];
		jusawi[2] = jusawi[1];
		jusawi[1] = jusawi[3];
		jusawi[3] = tmp;
	}

	public static void West() {
		int tmp = jusawi[0];
		jusawi[0] = jusawi[3];
		jusawi[3] = jusawi[1];
		jusawi[1] = jusawi[2];
		jusawi[2] = tmp;
	}

	public static void North() {
		int tmp = jusawi[0];
		jusawi[0] = jusawi[4];
		jusawi[4] = jusawi[1];
		jusawi[1] = jusawi[5];
		jusawi[5] = tmp;
	}

	public static void South() {
		int tmp = jusawi[0];
		jusawi[0] = jusawi[5];
		jusawi[5] = jusawi[1];
		jusawi[1] = jusawi[4];
		jusawi[4] = tmp;
	}

}
