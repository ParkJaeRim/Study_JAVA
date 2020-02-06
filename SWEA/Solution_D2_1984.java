package com.swea;

import java.util.Scanner;

public class Solution_D2_1984 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		int N = 10;
		int[] lst = new int[N];
		
		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < N; i++) {
				lst[i] = scanner.nextInt();
			}
			
			int MAX = Integer.MIN_VALUE;
			int MIN = Integer.MAX_VALUE;
			
			for (int i = 0; i < lst.length; i++) {
				MAX = MAX > lst[i] ? MAX : lst[i];
				MIN = MIN < lst[i] ? MIN : lst[i];
			}
			int sum =0;
			for (int i = 0; i < lst.length; i++) {
				if(lst[i] != MAX && lst[i] != MIN) {
					sum += lst[i];
				}
			}
			double avg = (double) sum / (lst.length-2);
			System.out.printf("#%d %.0f", tc, avg);
		}
	}

}
