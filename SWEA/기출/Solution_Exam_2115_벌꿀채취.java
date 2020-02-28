package com.swea;

import java.util.Scanner;

public class Solution_Exam_2115_벌꿀채취 {
	static int T, N, M, limit, ans, MAX, hap;
	static int[][] ggul;
	static boolean[][] visited;
	static int[] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();
			ggul = new int[N][N];
			M = scanner.nextInt(); // 선택가능갯수
			limit = scanner.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ggul[i][j] = scanner.nextInt();
				}
			}
			// 입력
			visited = new boolean[N][N];
			ans = 0;
			hap = 0;

			findA(visited);
			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void findA(boolean[][] visitedA) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				visitedA = new boolean[N][N];
				int sumA = 0;

				int[] listA = new int[M];
				for (int k = 0; k < M; k++) { // M개 선택
					if (!visitedA[i][j + k]) { // M개 선택 된 것을 visited배열에서 처리해주어 B가 선택되지 않게함.
						visitedA[i][j + k] = true;
					}
					listA[k] = ggul[i][j + k]; // 선택한 꿀들로 부분집합 구해줘야해서 저장.
				}
				MAX = 0;
				arr = new int[M + 1];
				subSet(listA, 0, 0);
				sumA = Math.max(sumA, MAX);
				findB(visitedA, sumA); // 선택된 일꾼A의 꿀통들과 연관하여 일꾼B의 꿀통을 고르는 함수 호출
			}
		}
	}

	public static void findB(boolean[][] visitedA, int sumA) {
		boolean[][] visitedB = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visitedA[i][j]) {
					visitedB[i][j] = true;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				int sumB = 0;
				int[] listB = new int[M];

				for (int k = 0; k < M; k++) {
					if (visitedB[i][j + k]) {
						break;
					} else {
						visitedB[i][j + k] = true;
						listB[k] = ggul[i][j + k];
						visitedB[i][j + k] = false;
					}
				}
				boolean flag = true;
				for (int k = 0; k < listB.length; k++) {
					if (listB[k] == 0) {
						flag = false;
					}
				}
				MAX = 0;
				if (flag) {
					arr = new int[M + 1];
					subSet(listB, 0, 0);
					sumB = Math.max(sumB, MAX);
					hap = sumA + sumB;
				} else {
					hap = 0;
				}
				ans = Math.max(ans, hap);
			}
		}
	}

	public static void subSet(int[] lst, int start, int cnt) {
		int subset_Max = 0;
		int powerSum = 0;
		int sum = 0;

		if (cnt > M) {
			return;
		}

		for (int i = 0; i < cnt; i++) {
			sum += arr[i];
			powerSum += Math.pow(arr[i], 2); // 구한 부분집합들의 제곱합
		}

		if (M >= cnt && sum <= limit) { // 부분집합의 요소갯수가 M보다 작은경우들
			subset_Max = Math.max(powerSum, subset_Max);
			MAX = Math.max(subset_Max, MAX); // 이전의 구한 MAX값과 비교하여 더 큰거 저장
		}
		for (int i = start; i < M; i++) {
			arr[cnt] = lst[i];
			subSet(lst, i + 1, cnt + 1);
		}
	}
}