package com.swea;

import java.util.Scanner;

public class Solution_D3_6485_삼성시의버스노선{
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int[] BusStop = new int[5001];
			
			for (int i = 0; i < N; i++) {
				int A = scanner.nextInt();
				int B = scanner.nextInt();
				for (int j = A; j <= B; j++) {
					BusStop[j]++;
				}
			}
			int P = scanner.nextInt();
			System.out.print("#"+tc+" ");
			for (int i = 0; i < P; i++) {
				int idx = scanner.nextInt();
				System.out.print(BusStop[idx]+" ");
			}
			System.out.println();
		}
	}
}
