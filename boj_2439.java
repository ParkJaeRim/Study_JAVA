package baekjoon;

import java.util.Scanner;

public class boj_2439 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int line = scanner.nextInt();
		
		for (int i=1; i<= line; i++) {
			for (int j = line-i; j>0; j--) {
				System.out.print(" ");
			}
			
			for (int k=1; k<=i; k++) {
				System.out.print("*");
			}
			System.out.
			println();
		}
	}
}