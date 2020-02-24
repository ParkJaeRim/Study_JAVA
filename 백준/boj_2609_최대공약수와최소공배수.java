package net.acmicpc;

import java.util.Scanner;

public class boj_2609_최대공약수와최소공배수 {
	static int A, B;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		A = scanner.nextInt();
		B = scanner.nextInt();
		
		GCD(A,B);
	
		
	}

	private static void GCD(int a, int b) {
		if(a==0) {
			System.out.println(b);
			if(A>=B) {
				System.out.println(A/b*B);
			}
			else {
				System.out.println(B/b*A);
			}
			return;
			
		}
		if(b==0) {
			System.out.println(a);
			if(A>=B) {
				System.out.println(A/a*B);
			}
			else {
				System.out.println(B/a*A);
			}
			return;
		}
		if(a>b) {
			GCD(a%b, b);
		}
		if(a<=b) {
			GCD(a,b%a);
		}
	}
}
