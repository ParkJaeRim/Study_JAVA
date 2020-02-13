package ssafy0213;

import java.util.Scanner;

public class Solution_4012_요리사 {

	static int N;
	static int R;
	static int[] cs;
	static int cnt;
	static boolean[] checked;
	static int map[][];
	static int sum, sum2;
	static int MIN;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = scanner.nextInt();
			R = N / 2;
			checked = new boolean[N];
			map = new int[N][N];
			cs = new int[N];
			MIN = Integer.MAX_VALUE;

			for (int i = 0; i < cs.length; i++) {
				cs[i] = i;
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = scanner.nextInt();
				}
			}
			System.out.println("#" + tc + " " + nCr(0, 0));
		}
	}
	
	//////////////////////////////////////////////////////////////
	
	public static int nCr(int start, int count) {
		if (count == R) {
			int[] as = new int[R];
			int[] bs = new int[R];
			int x = 0;
			int y = 0;
			sum = 0;
			sum2 = 0;

			for (int i = 0; i < checked.length; i++) {
				if (checked[i]) {
					as[x] = cs[i];
					x++;
				} else {
					bs[y] = cs[i];
					y++;
				}
			}
			int ans = food(as, bs);
			MIN = MIN < ans ? MIN : ans;
		}

		for (int i = start; i < N; i++) {
			if (!checked[i]) {
				checked[i] = true;
				nCr(i + 1, count + 1); // 동일문자 발생안함
				checked[i] = false;
			}
		}
		return MIN;
	}

	public static int food(int[] as, int[] bs) {
		for (int i = 0; i < as.length; i++) {
			for (int j = i + 1; j < as.length; j++) {
				sum += (map[as[i]][as[j]] + map[as[j]][as[i]]);
			}
		}
		for (int i = 0; i < bs.length; i++) {
			for (int j = i + 1; j < bs.length; j++) {
				sum2 += (map[bs[i]][bs[j]] + map[bs[j]][bs[i]]);
			}
		}
		int result = Math.abs(sum - sum2);
		return result;
	}

}
