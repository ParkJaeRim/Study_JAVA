package com.swea;

import java.util.Scanner;

public class Solution_D3_1209 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = 10;
		int N = 100;

		for (int tc = 1; tc <= T; tc++) {
			int K = scanner.nextInt();
			int[][] lst = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					lst[i][j] = scanner.nextInt();
				}
			}

			// 가로
			int MAX = Integer.MIN_VALUE;
			int sum = 0;

			for (int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < N; j++) {
					sum += lst[i][j];
				}
				MAX = MAX > sum ? MAX : sum;
			}
			System.out.println(MAX);

			for (int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < N; j++) {
					sum += lst[j][i];
				}
				MAX = MAX > sum ? MAX : sum;
			}

			sum = 0;
			for (int i = 0; i < N; i++) {
				sum += lst[i][i];
			
			}
			MAX = MAX > sum ? MAX : sum;

		
			sum = 0;
			for (int i = 0; i < N; i++) {
				sum += lst[i][N-i-1];				
			}
			MAX = MAX > sum ? MAX : sum;
		}
	}

}
