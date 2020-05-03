package net.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1551_수열의변화 {
	static int N, K;
	static int[] num;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		String[] lst = new String[N];
		K = scanner.nextInt();
		String s = scanner.next();
		num = new int[N];
		lst = s.split(",");

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < lst.length; i++) {
			arr.add(Integer.parseInt(lst[i]));
		}

		go(arr, K);

	}

	public static void go(ArrayList<Integer> al, int cnt) {
		if (cnt == 0) {
			String s = al.toString().replace(" ", "");
			System.out.println(s.substring(1, s.length() - 1));
			return;
		}
		ArrayList<Integer> bl = new ArrayList<>();
		bl.clear();
		for (int i = 0; i < al.size() - 1; i++) {
			bl.add(al.get(i + 1) - al.get(i));
		}
		go(bl, cnt - 1);
	}
}
