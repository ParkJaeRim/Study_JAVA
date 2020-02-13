package com.swea;

import java.util.Scanner;

public class Solution_D3_5601 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int T =scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = scanner.nextInt();
			
			System.out.print("#"+ tc);
			for (int i = 0; i < N; i++) {
				System.out.print(" "+"1/"+N);
			}
			System.out.println();
		}
	}

}
