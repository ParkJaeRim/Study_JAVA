package baekjoon;

import java.util.Scanner;

public class boj_10817 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nums[] = new int[3];
		
		for (int i=0; i<3; i++) {
			nums[i] = scanner.nextInt();
		}
		int A = nums[0];
		int B = nums[1];
		int C = nums[2];
		
		if(A < B) {
			if(B < C) {
				System.out.println(B);
			} else if (A < C) {
				System.out.println(C);
			} else {
				System.out.println(A);
			}
		} else {
			if(A < C) {
				System.out.println(A);
			} else if(C < B) {
				System.out.println(B);
			} else {
				System.out.println(C);
			}
		}
	}
}
