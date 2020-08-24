package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17471_개리멘더링 {
	static int N, teamA, teamB;

	static int[] team;
	static int[][] map;
	static boolean[] node_check, visited;

	static int[] ingu;
	static int minV;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		ingu = new int[N];
		map = new int[N][N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ingu[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			for (int j = 0; j < r; j++) {
				int to = Integer.parseInt(st.nextToken());
				map[i][to - 1] = 1;
			}
		}
		team = new int[N];
		minV = Integer.MAX_VALUE;
		ans = 0;

		comb(0, 0);

		if (minV == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minV);
		}
	}

	public static void comb(int cnt, int start) {
		if (cnt == N) {
			ans = 0;
			teamA = 0;
			teamB = 0;

			visited = new boolean[N];
			node_check = new boolean[N];
			for (int i = 0; i < team.length; i++) {
				if (team[i] == 3) {
					gary(i, 3);
					node_check[i] = true;
					visited[i] = true;
					break;
				}
			}
			if (TrueOrFalse(3)) {

				for (int i = 0; i < ingu.length; i++) {
					if (team[i] == 3) {
						teamA += ingu[i];
					}
				}

				visited = new boolean[N];
				node_check = new boolean[N];
				for (int i = 0; i < team.length; i++) {
					if (team[i] == 4) {
						gary(i, 4);
						node_check[i] = true;
						visited[i] = true;
						break;
					}
				}

				if (TrueOrFalse(4)) {
					for (int i = 0; i < ingu.length; i++) {
						if (team[i] == 4) {
							teamB += ingu[i];
						}
					}
					if (teamA != 0 && teamB != 0)
						minV = Math.min(minV, Math.abs(teamA - teamB));
				}
			}
			return;
		}

		for (int i = start; i < N; i++) {
			team[i] = 3;
			comb(cnt + 1, i + 1);
			team[i] = 4;
			comb(cnt + 1, i + 1);
		}
	}

	public static boolean TrueOrFalse(int whatTeam) {
		for (int i = 0; i < visited.length; i++) {
			if ((team[i] == whatTeam && !visited[i])) {
				return false;
			}
		}
		return true;
	}

	public static void gary(int startNode, int whatTeam) {
		for (int x = 0; x < N; x++) {
			if (map[startNode][x] == 1 && team[x] == whatTeam && !visited[x]) {
				visited[x] = true;
				gary(x, whatTeam);
			}
		}
	}

}
