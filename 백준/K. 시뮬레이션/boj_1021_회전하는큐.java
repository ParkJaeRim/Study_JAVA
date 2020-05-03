package net.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1021_회전하는큐 {
	static ArrayList<Integer> al, find;
	static int cnt;

	public static void main(String[] args) {
		al = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		for (int i = 1; i <= N; i++) {
			al.add(i);
		}

		int M = scanner.nextInt();
		find = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			find.add(scanner.nextInt());
		}

		/////////////// INPUT
		cnt = 0;
		go();
	}

	public static void go() {
		if (al.get(0) == find.get(0)) {
			al.remove(0);
			find.remove(0);
			if (find.size() == 0) {
				System.out.println(cnt);
				return;
			}
			go();
		}

		else {
			int idx = 0;
			for (int i = 0; i < al.size(); i++) {
				if (al.get(i) == find.get(0)) {
					idx = i;
				}
			}
			if ((idx - 0) < (al.size() - idx)) {
				int tmp = al.remove(0);
				al.add(tmp);
				cnt++;
				go();
			} else {
				int tmp = al.remove(al.size() - 1);
				al.add(0, tmp);
				cnt++;
				go();
			}
		}
	}
}
