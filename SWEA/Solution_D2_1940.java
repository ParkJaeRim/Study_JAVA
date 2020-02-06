package com.swea;

import java.util.Scanner;

public class Solution_D2_1940 {
	static int pl_mi;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int command = scanner.nextInt();
			int dist = 0;
			int speed = 0;

			for (int i = 0; i < command; i++) {
				int direct = scanner.nextInt();

				if (direct == 0) {
					dist += speed;

				} else if (direct == 1) {
					pl_mi = scanner.nextInt();
					speed += pl_mi;
					dist += speed;

				} else {
					pl_mi = scanner.nextInt();
					speed -= pl_mi;
					if (speed < 0) {
						speed = 0;
					}
					dist += speed;
				}
			}
			System.out.println("#" + tc + " " + dist);
		}
	}
}
