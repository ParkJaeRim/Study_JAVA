package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2941 {

	public static void main(String[] args) {
		Queue<Character> que = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		for (int i = 0; i < s.length(); i++) {
			que.offer(s.charAt(i));
		}
		int cnt = 0;
		while (!que.isEmpty()) {
			if (que.peek() == 'c' || que.peek() == 's' || que.peek() == 'z') {
				que.poll();
				if (!que.isEmpty() && (que.peek() == '-' || que.peek() == '=')) {
					que.poll();
					cnt += 1;
				} else {
					cnt += 1;
				}
			} else if (que.peek() == 'l' || que.peek() == 'n') {
				que.poll();
				if (!que.isEmpty() && que.peek() == 'j') {
					que.poll();
					cnt += 1;
				} else {
					cnt += 1;
				}
			}

			else if (que.peek() == 'd') {
				que.poll();
				if (!que.isEmpty() && que.peek() == '-') {
					que.poll();
					cnt += 1;
				} else if (!que.isEmpty() && que.peek() == 'z') {
					que.poll();
					if (!que.isEmpty() && que.peek() == '=') {
						que.poll();
						cnt += 1;
					} else {
						cnt += 2;
					}
				} else {
					cnt += 1;
				}
			} else {
				que.poll();
				cnt += 1;
			}

		}
		System.out.println(cnt);
	}

}
