package com.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1966 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int[] lst= new int[N];
			
			for (int i = 0; i < N; i++) {
				lst[i] = scanner.nextInt();
			}
			
			Arrays.sort(lst);
			
			System.out.print("#"+tc+" ");
			for (int i = 0; i < N; i++) {
				System.out.print(lst[i]+" ");
			}
			System.out.println();
		}
	}

}
