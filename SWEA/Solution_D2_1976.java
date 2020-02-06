package com.swea;

import java.util.Scanner;

public class Solution_D2_1976 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int a_hour = scanner.nextInt();
			int a_min = scanner.nextInt();
			int b_hour = scanner.nextInt();
			int b_min = scanner.nextInt();
			
			int carry = 0;
			int sum_min = a_min+b_min;
			
			if(sum_min>=60) {
				carry +=1;
				sum_min -= 60;
				
			}
			
			int sum_hour = carry+a_hour+b_hour;
			if(sum_hour >= 12) {
				sum_hour -= 12;
			}
			
			System.out.println("#"+tc+" "+sum_hour+" "+sum_min);
		}
	}
}