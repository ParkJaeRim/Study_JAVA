package com.swea;

import java.util.Scanner;

public class Solution_D1_1545 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] lst = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			lst[i] = i;
		}
		for (int j = lst.length-1; j >= 0 ; j--) {
			System.out.print(lst[j]+" ");
		}
	}

}
