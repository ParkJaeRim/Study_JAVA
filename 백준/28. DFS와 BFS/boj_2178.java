package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2178 {
	static int H, W, ny, nx, ey, ex;
	static int[][] map, depth;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		H = scanner.nextInt();
		W = scanner.nextInt();
		map = new int[H][W];
		depth = new int[H][W];
		visited = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			String s = scanner.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}

		ny = 0;
		nx = 0;
		ey = H - 1;
		ex = W - 1;
		depth[0][0] = 1;
		bfs(ny,nx);
		System.out.println(depth[ey][ex]);
	}

	public static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		visited[y][x] = true;
		que.offer(new int[] { y, x });

		while (!que.isEmpty()) {
			int[] current = que.poll();
			
			y = current[0];
			x = current[1];
			
			for (int d = 0; d < 4; d++) {
				ny = current[0] + dy[d];
				nx = current[1] + dx[d];

				if(check(ny,nx) && visited[ny][nx] == false && map[ny][nx]==1) {
					visited[ny][nx] = true;
					depth[ny][nx] = depth[y][x]+1;
					que.offer(new int[] {ny, nx});
				}
			}
		}
	}
	
	public static boolean check(int y, int x) {
		if(y>=0 && y<H && x>=0 && x<W) {
			return true;
		}
		else {
			return false;
		}
	}

}
