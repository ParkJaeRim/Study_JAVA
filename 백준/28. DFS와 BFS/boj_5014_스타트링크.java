package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_5014_스타트링크 {
	static int top, start, goal, up, down, ans;
	static int[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		top = scanner.nextInt();
		start = scanner.nextInt();
		goal = scanner.nextInt();
		up = scanner.nextInt();
		down = scanner.nextInt();
		visited = new int[top + 1];
		ans = 0;

		if (start > goal) {
			int tmp = start;
			start = goal;
			goal = tmp;

			tmp = up;
			up = down;
			down = tmp;
		}
		bfs(start, 0);

	}

	public static void bfs(int current, int cnt) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(current);
		visited[current] = 0;

		while (!que.isEmpty()) {

			int now = que.poll();

			if (now == goal) {
				System.out.println(visited[goal]);
				return;
			}

			if (now + up <= top && visited[now + up] == 0) {
				visited[now + up] = visited[now] + 1;
				que.offer(now + up);
			}

			if (now - down > 0 && visited[now - down] == 0) {
				visited[now - down] = visited[now] + 1;
				que.offer(now - down);
			}

		}
		System.out.println("use the stairs");

	}

}
