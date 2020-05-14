package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16235_나무재테크 {
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 5);
		}

		int[][] S2D2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S2D2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<Tree> LiveTree = new LinkedList<Tree>();
		List<Tree> DeadTree = new LinkedList<Tree>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int haeng = Integer.parseInt(st.nextToken());
			int yeol = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			LiveTree.add(new Tree(haeng - 1, yeol - 1, age));
		}

		///////////////////////////////////////////////

		int year = 0;
		while (K != year) {

			LiveTree.sort(new Comparator<Tree>() {
				public int compare(Tree t1, Tree t2) {
					return t1.age - t2.age;
				}
			});

			int storeTmp = LiveTree.size();

			// 봄
			for (int i = 0; i < storeTmp; i++) {
				Tree tmp = LiveTree.remove(0);
				int curTreeY = tmp.haeng;
				int curTreeX = tmp.yeol;
				int curTreeAge = tmp.age;

				if (map[curTreeY][curTreeX] >= curTreeAge) {
					map[curTreeY][curTreeX] -= curTreeAge;
					LiveTree.add(new Tree(curTreeY, curTreeX, curTreeAge + 1));
				} else {
					DeadTree.add(tmp);
				}
			}

			// 여름
			while (DeadTree.size() != 0) {
				Tree tmp = DeadTree.remove(0);
				if (tmp.age < 2) {
					continue;
				}
				int biryo = tmp.age / 2;
				map[tmp.haeng][tmp.yeol] += biryo;
			}

			// 가을
			int tmpLen = LiveTree.size();
			for (int i = 0; i < tmpLen; i++) {
				Tree tmp = LiveTree.remove(0);
				if ((tmp.age % 5) == 0) {
					for (int d = 0; d < 8; d++) {
						int nextY = tmp.haeng + dy[d];
						int nextX = tmp.yeol + dx[d];
						if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N)
							continue;
						LiveTree.add(new Tree(nextY, nextX, 1));
					}
				}
				LiveTree.add(tmp);
			}

			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += S2D2[i][j];
				}
			}
			year++;
		}
		System.out.println(LiveTree.size());
	}

	public static class Tree {
		int haeng;
		int yeol;
		int age;

		public Tree(int haeng, int yeol, int age) {
			this.yeol = yeol;
			this.haeng = haeng;
			this.age = age;
		}
	}
}
