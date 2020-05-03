package net.acmicpc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class boj_16865_드래곤커브 {
	static int startX, startY;
	static ArrayList<int[]> al;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[][] map = new int[120][120];

		for (int i = 0; i < N; i++) {
			startX = scanner.nextInt();
			startY = scanner.nextInt();
			int dir = scanner.nextInt();
			int generation = scanner.nextInt();

			Deque<Integer> deq = new LinkedList<>();
			al = new ArrayList<>();

			al.add(new int[] { startY, startX });
			deq.offer(dir);

			gene(deq, generation);
			for (int j = 0; j < al.size(); j++) {
				int[] tmp = al.get(j);
				map[tmp[0]][tmp[1]] = 1;
			}
		}
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	public static void gene(Deque<Integer> deq, int generation) {
		if (generation == 0) {
			while (!deq.isEmpty()) {
				int dragonDir = deq.pollLast();
				dragonMove(dragonDir);
			}
			return;
		}

		Deque<Integer> newDeq = new LinkedList<>();

		while (!deq.isEmpty()) {
			int tmp = deq.poll();
			newDeq.offer(tmp);
			if (tmp == 3) {
				newDeq.push(0);
			} else {
				newDeq.push(tmp + 1);
			}
		}
		gene(newDeq, generation - 1);

	}

	private static void dragonMove(int dragonDir) {
		int[] tmp = al.get(al.size() - 1);

		if (dragonDir == 0) {
			al.add(new int[] { tmp[0], tmp[1] + 1 });
		} else if (dragonDir == 1) {
			al.add(new int[] { tmp[0] - 1, tmp[1] });
		} else if (dragonDir == 2) {
			al.add(new int[] { tmp[0], tmp[1] - 1 });
		} else {
			al.add(new int[] { tmp[0] + 1, tmp[1] });
		}
	}
}
