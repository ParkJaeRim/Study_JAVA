package com.swea;

import java.util.Scanner;

public class Solution_D3_3975_승률비교하기 {
	static int T, A_win, A_tot, B_win, B_tot;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			A_win = scanner.nextInt();
			A_tot =  scanner.nextInt();
			
			B_win = scanner.nextInt();
			B_tot = scanner.nextInt();
			
			double A = (double)A_win/A_tot;
			double B = (double)B_win/B_tot;
			
			
			if(A>B) {
				System.out.println("#"+tc+" ALICE");
			}
			else if(A<B) {
				System.out.println("#"+tc+" BOB");
			}
			else{
				System.out.println("#"+tc+" DRAW");
			}
		}
	}
}
