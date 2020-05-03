package net.acmicpc;

import java.util.Scanner;

public class boj_5585_거스름돈 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		int money = 1000 - N;
		int HowMany = 0;

		if (money >= 500) {
			HowMany += money / 500;
			money -= 500 * HowMany;
		}
		if (money >= 100) {
			HowMany += money / 100;
			money -= 100 * (money / 100);
		}
		if (money >= 50) {
			HowMany += money / 50;
			money -= 50 * (money / 50);
		}
		if (money >= 10) {
			HowMany += money / 10;
			money -= 10 * (money / 10);
		}
		if (money >= 5) {
			HowMany += money / 5;
			money -= 5 * (money / 5);
		}
		if (money >= 1) {
			HowMany += money / 1;
			money -= 1 * (money / 1);
		}
		System.out.println(HowMany);
	}
}
