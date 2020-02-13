package com.swea;

import java.util.Scanner;

public class Solution_D3_3456 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int N = 3;
		for (int tc = 1; tc <= T; tc++) {
			int[] lst = new int[N];
			int[] dec= new int[N];
			for (int i = 0; i < N; i++) {
				lst[i] = scanner.nextInt();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0 ; j < N; j++) {
					if (i!=j && (lst[i] == lst[j] || lst[i] == lst[j])) {
						dec[i]++;
					}
					
				}
			}
			for (int i = 0; i < N; i++) {
				if(dec[i]!=1) {
					System.out.println("#"+tc+" "+lst[i]);
					break;
				}
			}

		}

	}

}
