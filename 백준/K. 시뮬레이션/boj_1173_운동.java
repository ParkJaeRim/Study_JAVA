package net.acmicpc;

import java.util.Scanner;

public class boj_1173_운동 {
	static int N, m, M, exercise, rest, minute, cnt;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		m = scanner.nextInt();
		M = scanner.nextInt();

		exercise = scanner.nextInt();
		rest = scanner.nextInt();

		int start = m;
		int minute = 0;
		int cnt = 0;
		
		if (start + exercise <= M) {
			doExercise(start, minute);
		} else {
			System.out.println(-1);
		}
	}

	public static void doExercise(int start, int minute) {
		if (minute == N) {
			System.out.println(cnt);
			return;
		}
		if (start + exercise <= M) {
			cnt++;
			doExercise(start + exercise, minute + 1);
		} else {
			if (start - rest < m) {
				cnt++;
				doExercise(m, minute);
			} else {
				cnt++;
				doExercise(start - rest, minute);
			}
		}
	}
}
