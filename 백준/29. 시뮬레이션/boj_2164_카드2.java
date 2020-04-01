package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2164_카드2 {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();

		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}

		while (que.size() != 1) {
			que.poll();
			int tmp = que.poll();
			que.offer(tmp);
		}
		int ans = que.poll();
		System.out.println(ans);
	}
}
