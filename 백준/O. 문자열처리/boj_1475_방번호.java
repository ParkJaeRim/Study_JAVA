package net.acmicpc;

import java.util.Scanner;

public class boj_1475_방번호{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String s = scanner.next();
		int[] arr = new int[10];
		int stringLen = s.length();

		for (int i = 0; i < stringLen; i++) {
			arr[Integer.parseInt(s.substring(i, i + 1))]++;
		}
		int tot = 0;

		if (arr[6] == 0) {
			tot = (int) Math.round((double) arr[9] / 2);
		} else if (arr[9] == 0) {
			tot = (int) Math.round((double) arr[6] / 2);
		} else if (arr[6] != 0 && arr[9] != 0) {
			if (arr[6] > arr[9]) {
				tot = arr[9]+ (int) Math.round((double) (arr[6]-arr[9]) / 2);;
			} else if (arr[9] >= arr[6]) {
				tot = arr[6]+ (int) Math.round((double) (arr[9]-arr[6]) / 2);;
			}
		}

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != 6 && i != 9)
				max = Math.max(max, arr[i]);
		}
		if (tot != 0 && (max > tot)) {
			tot += (max - tot);
		} else if (tot == 0) {
			tot += max;
		}
		System.out.println(tot);
	}
}
