package com.swea;

import java.util.Scanner;

public class Solution_D3_5431 {

	public static void main(String[] args) {
		Scanner scanner=  new Scanner(System.in);
		
		int T= scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			int[] student = new int[N+1];
			
			int K = scanner.nextInt();
			for (int i = 0; i < K; i++) {
				int num = scanner.nextInt();
				student[num]++;
			}
			
			System.out.print("#"+ tc);
			for (int i = 1; i < student.length; i++) {
				if(student[i] == 0) {
					System.out.print(" "+ i);
				}
			}System.out.println();
		}
	}

}
