package com.swea;

import java.util.Scanner;

public class Solution_D2_1959 {
	static int T, N, M;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();
			M = scanner.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			int MAX = Integer.MIN_VALUE;

			for (int i = 0; i < A.length; i++) {
				A[i] = scanner.nextInt();
			}
			for (int i = 0; i < B.length; i++) {
				B[i] = scanner.nextInt();
			}

			if (N <= M) {
				int x = 0;
				int[] result = new int[M - N+1];
				while (x <= M - N) {
					int sum = 0;
					for (int i = 0; i < N; i++) {
						sum += A[i] * B[i + x];
						result[x] = sum;

					}
					x++;
				}
				for (int i = 0; i < result.length; i++) {
					MAX = MAX > result[i] ? MAX : result[i];
				}

			} else {
				int y = 0;
				int[] result = new int[N-M+1];
				while (y <= N-M) {
					int sum_ = 0;
					for (int i = 0; i < M; i++) {
						
						sum_ += B[i] * A[i+y];
						result[y] = sum_;

					}
					y++;
				}
				for (int i = 0; i < result.length; i++) {
					MAX = MAX > result[i] ? MAX : result[i];
				}

			}
			System.out.println("#" + tc + " " + MAX);
		}

	}
}