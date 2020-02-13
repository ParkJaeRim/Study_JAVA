package com.swea;

import java.util.Scanner;

public class Solution_D3_3314 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int N = 5;
		for (int tc = 1; tc <= T; tc++) {
			int[] lst = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				lst[i] =scanner.nextInt();
				if(lst[i] < 40) {
					lst[i] =40;
				}
				sum += lst[i];
			}
			int avg = sum/N;
			System.out.println("#"+tc+" "+avg);
		}		
		

	}

}
