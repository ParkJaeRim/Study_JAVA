package com.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_4466 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T =scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int K = scanner.nextInt();
			int[] score = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				score[i] = scanner.nextInt();
			}
			
			Arrays.sort(score);
			
			for (int i = N-1; i > score.length-1-K; i--) {
				sum += score[i];
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}

}
