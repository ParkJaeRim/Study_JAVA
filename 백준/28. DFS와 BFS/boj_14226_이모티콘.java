package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_14226_이모티콘 {
	static int end;
	static int limit = 2001;
	static int[][] visited;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		end = scanner.nextInt();
		visited = new int[limit][limit];
		for (int i = 0; i < limit; i++) {
			Arrays.fill(visited[i], -1);
		}
		emoticon(0, 1);
	}

	public static void emoticon(int SC, int SM) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { SC, SM });
		visited[SC][SM] = 0; // 0,1 = 1 -> 클립보드가 0이고 화면에 1인것

		while (!que.isEmpty()) {
			int[] x = que.poll();
			int clip = x[0];
			int monitor = x[1];
			
//			print(visited, clip, monitor);
			if(monitor == end) {
				System.out.println(visited[clip][monitor]);
				return;
			}
			
			// 복사
			if (clip + monitor < limit && visited[monitor][monitor] == -1) {
				que.offer(new int[] { monitor, monitor });
				visited[monitor][monitor] = visited[clip][monitor] + 1;
				
//				System.out.println("복사");
//				print(visited, monitor, monitor);
			}
			
			// 붙이기
			if (clip + monitor < limit && visited[clip][clip + monitor] == -1) {
				que.offer(new int[] { clip, clip + monitor });
				visited[clip][clip + monitor] = visited[clip][monitor] + 1;
				
//				System.out.println("붙이기");
//				print(visited, clip, monitor+clip);
			}

			if (monitor - 1 > 0 && visited[clip][monitor - 1] == -1) {
				que.offer(new int[] { clip, monitor - 1 });
				visited[clip][monitor - 1] = visited[clip][monitor] + 1;
				
//				System.out.println("삭제");
//				print(visited, clip, monitor);
			}

		}

	}

	public static void print(int[][] visited, int store, int show) {
		System.out.println("클립보드에 저장된 수 : " + store + " 현재 화면 : " + show);
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				System.out.print(visited[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
