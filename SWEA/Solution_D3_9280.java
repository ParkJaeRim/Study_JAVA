package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_9280 {
	static int n, m;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			Queue<Integer> Q = new LinkedList<>();

			n = scanner.nextInt();
			m = scanner.nextInt();

			int pay = 0;
			int[] parking_lot = new int[n + 1];

			int[] cost = new int[n + 1];
			int[] weight = new int[m + 1];

			for (int i = 1; i < n + 1; i++) {
				cost[i] = scanner.nextInt();
			}
			for (int j = 1; j < m + 1; j++) {
				weight[j] = scanner.nextInt();
			}
			int cnt = 0;

			Queue<Integer> tq = new LinkedList<>();

			for (int i = 0; i < 2 * m; i++) {
				int car = scanner.nextInt();
				cnt = 0;
				////////////////////////////////////
				for (int j = 1; j < n + 1; j++) {
					if (car >= 0) {

						if (parking_lot[j] == 0) { // 만약 어느 방이 차지 않았다면,
							parking_lot[j] = car; // 앞에서부터 탐색하니까, 어떤 방이 0이 아닌 곳에 car번호를 넣어줌.
							pay += cost[j] * weight[car]; // 가격은 += cost[어떤 방] * 해당자동차의 무게
							break;
						}
						else if (parking_lot[j] != 0) {
							cnt += 1;
						}
					}

					if (cnt == n) {
						tq.offer(car);
					}

					else if (car < 0) {
						for (int k = 1; k < parking_lot.length; k++) {
							if (parking_lot[k] == -(car)) {
								parking_lot[k] = 0;

								if (!tq.isEmpty()) {
									int tq_tmp = tq.poll();

									for (int xx = 1; xx < parking_lot.length; xx++) {
										if (parking_lot[xx] == 0) {
											parking_lot[xx] = tq_tmp;
											pay += cost[xx] * weight[tq_tmp];
										}
									}

								}
							}
						}
					}
				}
			}
			tq.clear();
			System.out.println("#" + tc + " " + pay);
		}

	}
}
