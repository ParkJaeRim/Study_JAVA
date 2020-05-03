package com.swea;

import java.util.Scanner;

public class boj_1929 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		int len = N - M + 1;
		//에라토스테네스 체 :  찾고싶은 수의 제곱근보다 작은 소수의 배수들을 지우면 소수만 구할 수 있다.
		int[] lst = new int[len];
		boolean[] dec = new boolean[N + 1];

		for (int i = M; i <= N; i++) {
			lst[i - M] = i;
		}
		dec[1] = true;
		for (int i = 0; i < lst.length; i++) {
			for (int j = 2; j <= Math.sqrt(N); j++) {
				if (lst[i] != j && lst[i] % j == 0) {
					dec[lst[i]] = true;
				}
			}
		}

		for (int j = M; j < dec.length; j++) {
			if (!dec[j]) {
				System.out.println(lst[j - M]);
			}
		}
	}
}