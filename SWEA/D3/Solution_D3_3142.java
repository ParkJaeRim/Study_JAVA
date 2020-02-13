package com.swea;

import java.util.Scanner;

public class Solution_D3_3142 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int B = scanner.nextInt();
			
			int horn = N/2;
			int uni = N-2*horn;
			
			while(horn+uni!=B) {
				horn--;
				uni = N-2*horn;
			}
			System.out.println("#" + tc +" "+uni+" "+ horn);
		}
	}

}
