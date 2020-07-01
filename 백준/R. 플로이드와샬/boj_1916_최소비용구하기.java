package net.acmicpc;

import java.util.Scanner;

public class boj_1916_최소비용구하기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int M = scanner.nextInt();

		int[][] graph = new int[N + 1][N + 1];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				graph[i][j] = 1000001;
			}
		}
		for (int i = 0; i < M; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int value = scanner.nextInt();
			graph[u][v] = Math.min(graph[u][v], value);
		}
		for (int i = 1; i < graph.length; i++) {
			for (int j = 1; j < graph[i].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		int start = scanner.nextInt();
		int goal = scanner.nextInt();

		for (int k = 0; k < N + 1; k++) {
			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j < N + 1; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		System.out.println(graph[start][goal]);
	}

}
