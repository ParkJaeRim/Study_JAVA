package net.acmicpc;

import java.util.Scanner;

public class boj_5532_방학숙제 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int vacation = scanner.nextInt();
		int K = scanner.nextInt();
		int M = scanner.nextInt();
		int Kmax = scanner.nextInt();
		int Mmax = scanner.nextInt();

		int Kday = 0;
		Kday += K / Kmax;

		int Mday = 0;
		Mday += M / Mmax;

		if (K % Kmax != 0) {
			Kday += 1;
		}

		if (M % Mmax != 0) {
			Mday += 1;
		}

		int ans = 0;
		if (Kday > Mday) {
			ans = vacation - Kday;
		} else {
			ans = vacation - Mday;
		}
		
		System.out.println(ans);

	}
}
