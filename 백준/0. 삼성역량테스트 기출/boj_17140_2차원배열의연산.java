package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17140_2차원배열의연산 {
	static int[][] map;
	static int haeng, yeol, R, C, K;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (st.hasMoreTokens()) {
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		}

		map = new int[101][101];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		// 입력 완료//
		int time = 0;
		flag = false;
		while (true) {
			if (map[R - 1][C - 1] == K) {
				System.out.println(time);
				break;
			}
			if (time >= 100) {
				System.out.println(-1);
				break;
			}
			checkRC();
			if (haeng >= yeol) {
				doR();
			} else {
				doC();
			}
			time++;
		}
	}

	public static void doR() {
		for (int i = 0; i < map.length; i++) {
			List<Edge> lst = new LinkedList<>();
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					if (lst.size() == 0) {
						lst.add(new Edge(map[i][j], 1, i));
					} else {
						boolean go = false;
						int store = 0;
						for (int m = 0; m < lst.size(); m++) {
							if (lst.get(m).haeng == i) {
								if (lst.get(m).value == map[i][j]) {
									store = m;
									go = true;
									break;
								}
							}
						}
						if (go) {
							lst.get(store).cnt++;
						} else {
							lst.add(new Edge(map[i][j], 1, i));
						}

					}
				}
			}

			lst.sort(new Comparator<Edge>() {
				public int compare(Edge e1, Edge e2) {
					if (e1.cnt == e2.cnt) {
						return e1.value - e2.value;
					}
					return e1.cnt - e2.cnt;
				}
			});

			int idx = 0;
			for (int j = 0; j < map.length; j++) {
				Arrays.fill(map[i], 0);
			}

			for (int j = 0; j < lst.size(); j++) {
				if (lst.get(j).value != 0) {
					map[i][idx] = lst.get(j).value;
					map[i][idx + 1] = lst.get(j).cnt;
					idx += 2;
					if (idx >= 99) {
						return;
					}

				}
			}
		}

	}

	public static void doC() {
		for (int i = 0; i < map.length; i++) {
			List<Edge> lst = new LinkedList<>();
			for (int j = 0; j < map[i].length; j++) {
				if (map[j][i] != 0) {
					if (lst.size() == 0) {
						lst.add(new Edge(map[j][i], 1, i));
					} else {
						boolean go = false;
						int store = 0;
						for (int m = 0; m < lst.size(); m++) {
							if (lst.get(m).haeng == i) {
								if (lst.get(m).value == map[j][i]) {
									// 이미 있다면
									store = m;
									go = true;
								}
							}
						}
						if (go) {
							lst.get(store).cnt++;
						} else {
							lst.add(new Edge(map[j][i], 1, i));
						}

					}
				}

			}
			lst.sort(new Comparator<Edge>() {
				public int compare(Edge e1, Edge e2) {
					if (e1.cnt == e2.cnt) {
						return e1.value - e2.value;
					}
					return e1.cnt - e2.cnt;
				}
			});

			int idx = 0;

			for (int j = 0; j < map[i].length; j++) {
				map[j][i] = 0;
			}
			for (int j = 0; j < lst.size(); j++) {
				if (lst.get(j).value != 0) {
					map[idx][i] = lst.get(j).value;
					map[idx + 1][i] = lst.get(j).cnt;
					idx += 2;
					if (idx >= 99) {
						return;
					}
				}
			}
		}

	}

	public static void checkRC() {
		haeng = 0;
		yeol = 0;

		for (int i = 0; i < map.length; i++) {
			boolean flagH = false;

			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					flagH = true;
					break;
				}
			}
			if (flagH) {
				haeng++;
			}
		}

		for (int i = 0; i < map.length; i++) {
			boolean flagC = false;
			for (int j = 0; j < map[i].length; j++) {
				if (map[j][i] != 0) {
					flagC = true;
				}
			}
			if (flagC) {
				yeol++;
			}
		}

	}

	public static class Edge {
		int value;
		int cnt;
		int haeng;

		public Edge(int value, int cnt, int haeng) {
			this.value = value;
			this.cnt = cnt;
			this.haeng = haeng;
		}
	}

	public static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
