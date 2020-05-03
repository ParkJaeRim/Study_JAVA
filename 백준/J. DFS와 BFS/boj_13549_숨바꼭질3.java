package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_13549_숨바꼭질3 {
	static int start, end;
	static int[] current;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		start = scanner.nextInt();
		end = scanner.nextInt();

		current = new int[20];
		Arrays.fill(current, -1);
		if (start == end) {
			System.out.println(0);
		} else {
			bfs(start, end);
			System.out.println(current[end]);
		}
	}

	public static void bfs(int a, int b) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(a);
		current[a] = 0;

		while (!que.isEmpty()) {
			int x = que.poll();
			
			if (current[b] != -1) {
				break;
			}
			if (x * 2 < current.length - 1 && current[x * 2] == -1) {
				current[x * 2] = current[x];
				que.offer(x * 2);
			}

			if (x - 1 >= 0 && current[x - 1] == -1) {
				que.offer(x - 1);
				current[x - 1] = current[x] + 1;
			}
			if (x + 1 < current.length - 1 && current[x + 1] == -1) {
				que.offer(x + 1);
				current[x + 1] = current[x] + 1;
			}

		}

	}
}
