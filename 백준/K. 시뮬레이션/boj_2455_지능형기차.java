package net.acmicpc;

import java.util.Scanner;

public class boj_2455_지능형기차 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] train = new int[4];
		int maxppl = 0;

		for (int i = 0; i < train.length; i++) {
			int out = scanner.nextInt();
			int in = scanner.nextInt();
			if (i == 0) {
				train[0] = in;
				maxppl = in;
			} else {
				train[i] = train[i - 1] + in - out;
				maxppl = Math.max(maxppl, train[i]);
			}
		}
		System.out.println(maxppl);
	}
}
