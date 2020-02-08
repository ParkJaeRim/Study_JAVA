package com.swea;

import java.util.Scanner;

public class Solution_D2_1288 {
	static int[] num;
	static int N, T, i;
//	static boolean[] all;
	static int[] all;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();

			all = new int[10];

			i = 1;
			sheep(N);
			System.out.println("#"+ tc + " " + (i*N));

		}
	}

	public static void sheep(int N) {
		
		String s = Integer.toString(N*i);
		int cnt =0;
		
		for (int j = 0; j < s.length(); j++) {
			all[s.charAt(j)-'0'] += 1;
			
		}
		
		for (int i = 0; i < all.length; i++) {
			if(all[i]==0) {
				cnt ++;
			}
		}
		if(cnt > 0) {
			i++;
			sheep(N);
		}
		else {
			return ;
		}
	}
	
}