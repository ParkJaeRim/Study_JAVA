package com.swea;

import java.util.Scanner;

public class boj_1978 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int X = scanner.nextInt();
			boolean dec = false;
			
			if(X==1) {
				dec = true;
			}
			
			for (int j = 2; j < X; j++) {
				if(X%j == 0) {
					dec = true;
				}
				
			}
			
			if(!dec) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}