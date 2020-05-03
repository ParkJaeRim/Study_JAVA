package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7576 {
	static int H, W, ny, nx, y,x;
	static int[][] map, depth;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		W = scanner.nextInt();
		H = scanner.nextInt();
		map = new int[H][W];
		depth = new int[H][W];
		visited = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		Queue<int[]> que = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 1) {
					que.offer(new int[] { i, j });
					visited[i][j] = true;
				}

			}
		}
		while (!que.isEmpty()) {
			int[] current = que.poll();

			y = current[0];
			x = current[1];

			for (int d = 0; d < 4; d++) {
				ny = current[0] + dy[d];
				nx = current[1] + dx[d];

				if (check(ny, nx) && visited[ny][nx] == false && map[ny][nx] == 0) {
					visited[ny][nx] = true;
					depth[ny][nx] = depth[y][x] + 1;
					que.offer(new int[] { ny, nx });
//					print(depth);
				}
			}
		}
		
		int MAX = Integer.MIN_VALUE;
		aa : for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				MAX = MAX > depth[i][j] ? MAX : depth[i][j];
				if(map[i][j] != -1 && !(visited[i][j])) {
					MAX = -1;
					break aa;
				}

			}
		}
		System.out.println(MAX);
	}

	public static boolean check(int y, int x) {
		if (y >= 0 && y < H && x >= 0 && x < W) {
			return true;
		} else {
			return false;
		}
	}

//	public static void print(int[][] lst) {
//		for (int i = 0; i < lst.length; i++) {
//			for (int j = 0; j < lst[i].length; j++) {
//				System.out.print(lst[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//	public static void print(boolean[][] lst) {
//		for (int i = 0; i < lst.length; i++) {
//			for (int j = 0; j < lst[i].length; j++) {
//				System.out.print(lst[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}
