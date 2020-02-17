package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_4963{
	static int w, h, ny, nx, num;
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static boolean[][] visited;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		do {
			w = scanner.nextInt();
			h = scanner.nextInt();
			if(w==0 && h==0) {
				break;
			}
			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				String s = scanner.next();
				for (int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}

			num = 1;
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && visited[i][j] == false) {
						bfs(i, j);
						num++;
					}
				}
			}
			System.out.println(num - 1);
		} while (w != 0 || h != 0);
	}

	public static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { y, x });
		visited[y][x] = true;

		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int d = 0; d < 8; d++) {
				ny = curr[0] + dy[d];
				nx = curr[1] + dx[d];

				if (ny >= 0 && ny < h && nx >= 0 && nx < w && visited[ny][nx] == false && map[ny][nx] == 1) {
					visited[ny][nx] = true;
					map[ny][nx] = num;
					que.offer(new int[] { ny, nx });
					print(map);
				}
			}
		}

	}
	
	public static void print(int[][] lst) {
		for (int i = 0; i < lst.length; i++) {
			for (int j = 0; j < lst[i].length; j++) {
				System.out.println(lst[i][j]);
			}
		}
	}

}
