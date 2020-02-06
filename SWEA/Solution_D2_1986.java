package com.swea;

import java.util.Scanner;

public class Solution_D2_1986 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int[] lst = new int[N];
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
//				lst[i] =i+1;
				if((i+1)%2 ==1) {
					cnt +=(i+1);
				}
				else {
					cnt -= (i+1);
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
