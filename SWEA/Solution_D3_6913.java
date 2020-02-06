package com.swea;

import java.util.Scanner;

public class Solution_D3_6913 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T ; tc++) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			
			int[][] solve = new int[N][M];
			int[] score = new int[N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					solve[i][j] = scanner.nextInt();
				}
			}
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if(solve[x][y] == 1) {
						score[x] += 1;
					}
					
				}
			}
			int MAX = 0;
			for (int k = 0; k < score.length; k++) {
				MAX = score[k]>MAX ? score[k] : MAX;
			}
			int cnt_winner = 0;
			for (int m = 0; m < score.length; m++) {
				if(score[m]== MAX) {
					cnt_winner += 1;
				}
			}
			System.out.println("#"+tc+" "+cnt_winner+" " + MAX);
		}
	}

}
