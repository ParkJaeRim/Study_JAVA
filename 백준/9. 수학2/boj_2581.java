package com.swea;

import java.util.Scanner;

public class boj_2581 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		int sum = 0;
		int MIN = Integer.MAX_VALUE;
		int cnt = 0;
		for (int i = M; i <= N; i++) {
			boolean dec = false;

			if (i == 1) {
				dec = true;
			}
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					dec = true;
				}
			}
			if (!dec) {
				sum += i;
				cnt++;
				MIN = MIN < i ? MIN : i;
			}
			
		}
		if(cnt == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(MIN);
			
		}
	}
}