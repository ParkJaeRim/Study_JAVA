package com.swea;

import java.util.Scanner;

public class Solution_D1_2019 {
	static int result;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] lst = new int[N+1];
		
		int i = 0;
		result = 0;
		while(i!=N) {
			int result = (int) Math.pow(2, i);
			i++;
			System.out.print(result + " ");
		}
	}

}
