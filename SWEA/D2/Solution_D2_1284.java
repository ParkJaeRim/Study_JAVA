package com.swea;

import java.util.Scanner;

public class Solution_D2_1284 {
	static int P, Q, R, S, W;
	static int result_A, result_B;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			P = scanner.nextInt();
			Q = scanner.nextInt();
			R = scanner.nextInt();
			S = scanner.nextInt();
			W = scanner.nextInt();
			
			result_A = P*W;
			
			if(W <= R ) {
				result_B = Q;
			}
			else {
				result_B = Q + (W-R) *S;
			}
			
			if(result_A >= result_B) {
				System.out.println("#" + tc + " " + result_B);
			}
			else {
				System.out.println("#" + tc + " " + result_A);
			}
		}

	}

}
