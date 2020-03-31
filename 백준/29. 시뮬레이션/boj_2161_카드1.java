package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2161_카드1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}

		while (!que.isEmpty()) {
			System.out.print(que.poll()+" ");
			if (que.isEmpty()) {
				break;
			}
			int tmp = que.poll();
			que.offer(tmp);
		}

	}
}
