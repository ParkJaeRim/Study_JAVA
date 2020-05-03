package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_3190_뱀 {
	static int[] dy = new int[] { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dx = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int appleY = Integer.parseInt(st.nextToken());
			int appleX = Integer.parseInt(st.nextToken());
			map[appleY][appleX] = 3;
		}

		ArrayList<Info> al = new ArrayList<>();
		ArrayList<int[]> snake = new ArrayList<>();

		int time = 0;

		int L = Integer.parseInt(br.readLine());
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String snakeDir = st.nextToken();
			al.add(new Info(sec, snakeDir));
		}
		int startY = 1;
		int startX = 1;
		int startD = 0;

		boolean[][] visited = new boolean[N + 1][N + 1];
		visited[startY][startX] = true;
		snake.add(new int[] { startY, startX });

		aa: while (al.size() >= 0) {
			if (al.size() == 0) {
				int moveY = startY + dy[startD];
				int moveX = startX + dx[startD];
				if (moveY >= 1 && moveX >= 1 && moveY <= N && moveX <= N && !visited[moveY][moveX]) {
					snake.add(new int[] { moveY, moveX });
					if (map[moveY][moveX] != 3) {
						int[] removeSnake = snake.remove(0);
						map[removeSnake[0]][removeSnake[1]] = 0;
						visited[removeSnake[0]][removeSnake[1]] = false;
					}
					for (int i = 0; i < snake.size(); i++) {
						int[] pos = snake.get(i);
						map[pos[0]][pos[1]] = 1;
						visited[pos[0]][pos[1]] = true;
					}
					startY = moveY;
					startX = moveX;
					time++;
				} else {
					break aa;
				}
			} else {
				Info tmp = al.get(0);
				int changeSec = tmp.sec;
				String changeDir = tmp.snakeDir;

				map[startY][startX] = 1;

				while (time != changeSec) {
					int moveY = startY + dy[startD];
					int moveX = startX + dx[startD];

					if (moveY >= 1 && moveX >= 1 && moveY <= N && moveX <= N && !visited[moveY][moveX]) {
						snake.add(new int[] { moveY, moveX });

						if (map[moveY][moveX] != 3) {
							int[] removeSnake = snake.remove(0);
							map[removeSnake[0]][removeSnake[1]] = 0;
							visited[removeSnake[0]][removeSnake[1]] = false;
						}

						for (int i = 0; i < snake.size(); i++) {
							int[] pos = snake.get(i);
							map[pos[0]][pos[1]] = 1;
							visited[pos[0]][pos[1]] = true;
						}

						startY = moveY;
						startX = moveX;
						time++;

					} else {
						break aa;
					}
				}

				if (startD == 0) {
					if (changeDir.equals("D")) {
						startD = 1;
					} else {
						startD = 3;
					}
				} else if (startD == 1) {
					if (changeDir.equals("D")) {
						startD = 2;
					} else {
						startD = 0;
					}
				} else if (startD == 2) {
					if (changeDir.equals("D")) {
						startD = 3;
					} else {
						startD = 1;
					}
				} else if (startD == 3) {
					if (changeDir.equals("D")) {
						startD = 0;
					} else {
						startD = 2;
					}
				}
				al.remove(0);
			}
		}
		System.out.println(time + 1);
	}

	public static class Info {
		int sec;
		String snakeDir;

		public Info(int sec, String snakeDir) {
			this.sec = sec;
			this.snakeDir = snakeDir;
		}
	}
}
