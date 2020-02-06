package com.swea;

import java.util.Scanner;

public class Solution_D2_1970 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int num = scanner.nextInt();
			int[] money = new int[8];
			
			money[0] = num/50000;
			money[1] = (num - money[0]*50000) / 10000;
			
			money[2] = (num-(50000*money[0] + 10000*money[1])) /5000 ;
			money[3] = (num-(50000*money[0] + 10000*money[1] + 5000*money[2])) /1000 ;
			
			money[4] = (num-(50000*money[0] + 10000*money[1]+ 5000*money[2]+1000*money[3])) /500 ;
			money[5] = (num-(50000*money[0] + 10000*money[1]+ 5000*money[2]+1000*money[3]+500*money[4])) /100 ;

			money[6] = (num-(50000*money[0] + 10000*money[1]+ 5000*money[2]+1000*money[3]+500*money[4]+100*money[5])) /50 ;
			money[7] = (num-(50000*money[0] + 10000*money[1]+ 5000*money[2]+1000*money[3]+500*money[4]+100*money[5]+50*money[6])) /10 ;
			
			System.out.println("#"+ tc);
			for (int i = 0; i < money.length; i++) {
				System.out.print(money[i]+ " ");
			}
			System.out.println();
		}
	}

}
