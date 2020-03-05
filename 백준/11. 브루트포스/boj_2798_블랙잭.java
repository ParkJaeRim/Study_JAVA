package net.acmicpc;

import java.util.Scanner;

public class boj_2798_블랙잭 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int limit = scanner.nextInt();
		int[] lst = new int[N];
		int sum = 0;
		int MAX = Integer.MIN_VALUE;
		
		for (int i = 0; i < lst.length; i++) {
			lst[i] = scanner.nextInt();
		}
		for (int i = 0; i < lst.length; i++) {
			for (int j = i+1; j < lst.length; j++) {
				for (int k = j+1; k < lst.length; k++) {
					sum = lst[i]+lst[j]+lst[k];
					if(sum <= limit) {
						MAX = MAX > sum ? MAX : sum;
					}
				}
			}
		}
		System.out.println(MAX);
	}

}

		
	}

}
