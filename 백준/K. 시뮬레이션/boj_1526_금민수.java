package net.acmicpc;

import java.util.Scanner;

public class boj_1526_금민수 {
	static String ans;
	static boolean flag;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		ans = "";
		go(N);
		System.out.println(ans);
	}

	public static String go(int n) {
		String s = Integer.toString(n);
		flag = false;
		for (int i = 0; i < s.length(); i++) {
			String tmp = s.substring(i, i + 1);
			if (!tmp.equals("4") && !tmp.equals("7")) {
				flag = true;
				break;
			}
		}
		if (flag) {
			go(n - 1);
		} else {
			ans = s;
			return ans;
		}
		return "";
	}
}
