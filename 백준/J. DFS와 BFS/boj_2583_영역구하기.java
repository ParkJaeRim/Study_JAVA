package com.swea;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2583 {
	static int hang, yeol, danji, ax, ay, bx, by;
	static int[][] map;
	static int[][] count;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] xx;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		hang = scanner.nextInt();
		yeol = scanner.nextInt();

		map = new int[hang][yeol];
		count = new int[hang][yeol];
		visited = new boolean[hang][yeol];
		xx = new int[10000];
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			ax = scanner.nextInt();
			ay = scanner.nextInt();
			bx = scanner.nextInt();
			by = scanner.nextInt();

			for (int j = ay; j < by; j++) {
				for (int k = ax; k < bx; k++) {
					map[j][k] = 1;
				}
			}
		}
		danji = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0 && visited[i][j]== false ) {
					bfs(i, j);
					danji++;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i].length; j++) {
				max = Math.max(max, count[i][j]);
				if(count[i][j] !=0)
				xx[count[i][j]]++;
			}
		}
		
		System.out.println(max);
		Arrays.sort(xx);
		for (int i = 0; i < xx.length; i++) {
			if(xx[i] !=0 ) {
				System.out.print(xx[i]+" ");
			}
		}
	}

	public static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { y, x });
		int cnt = 0;
		count[y][x] =danji;
				
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur[0] + dy[d];
				int nx = cur[1] + dx[d];

				if (check(ny, nx) && !visited[ny][nx] && map[ny][nx] == 0) {
					visited[ny][nx] = true;
					count[ny][nx] = danji;
					cnt++;
					que.offer(new int[] { ny, nx });
					
				}
			}
		}
//		print(count);

	}
	
/////////////////////////////////////////////////
	public static boolean check(int y, int x) {
		if (y >= 0 && y < hang && x >= 0 && x < yeol) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[][] lst) {
		for (int i = 0; i < lst.length; i++) {
			for (int j = 0; j < lst[i].length; j++) {
				System.out.print(lst[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
