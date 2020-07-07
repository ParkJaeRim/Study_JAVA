package net.acmicpc;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_11279_최대힙 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int x = scanner.nextInt();
			if (que.isEmpty()) {
				if (x == 0) {
					System.out.println(0);
				}else {
					que.offer(x);
				}
			} else {
				if (x == 0) {
					System.out.println(que.poll());
				} else {
					que.offer(x);
				}
			}
		}
	}

}
