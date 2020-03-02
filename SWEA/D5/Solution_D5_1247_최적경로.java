import java.util.Scanner;

public class Solution_D5_1247_최적경로 {
	static int T, N, start_y, start_x, end_y, end_x;
	static int[] dy;
	static int[] dx;
	static boolean[] visited;
	static int MIN_SUM;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();

			dy = new int[N+2];
			dx = new int[N+2];

			MIN_SUM = Integer.MAX_VALUE;

			for (int i = 0; i < N+2; i++) {
				dy[i] = scanner.nextInt();
				dx[i] = scanner.nextInt();
			}

			int[] arr_y = new int[N+2];
			int[] arr_x = new int[N+2];
			arr_y[0] = dy[0];
			arr_x[0] = dx[0];
			arr_y[N+1] = dy[1];
			arr_x[N+1] = dx[1];
			
			perm(arr_y, arr_x, 0, 0);
			System.out.println("#" + tc + " " + MIN_SUM);
		}
	}

	public static void perm(int[] arr_y, int[] arr_x, int flag, int cnt) {
		if (cnt == N) {

			int cal = 0;
			for (int i = 0; i < arr_x.length - 1; i++) {
				cal += Math.abs(arr_y[i + 1] - arr_y[i]) + Math.abs(arr_x[i] - arr_x[i + 1]);
			}
			if (cal < MIN_SUM) {
				MIN_SUM = cal;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			if ((flag & 1 << i) == 0) {
				arr_y[cnt+1] = dy[i+2];
				arr_x[cnt+1] = dx[i+2];
				perm(arr_y, arr_x, flag | 1 << i, cnt + 1);
			}
		}
	}
}