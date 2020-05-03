package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_1966_프린터큐 {
	static int T, N, idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken()); // 테케 수
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			if (st.hasMoreTokens()) {
				N = Integer.parseInt(st.nextToken());
				idx = Integer.parseInt(st.nextToken());
			}
			LinkedList<int[]> que = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			int no = 0;
			while (st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				que.offer(new int[] { no, x });
				no++;
			}

			int cnt = 0;
			while (!que.isEmpty()) {
				boolean flag = false;
				int[] tmp = que.poll();
				for (int i = 0; i < que.size(); i++) {
					if (tmp[1] < que.get(i)[1]) {
						// 여기서 계속 잘못 생각 함....poll했기 때문에 i=1부터 시작하면 안됐음.
						flag = true;
						break;
					}
				}

				if (flag) {
					que.add(tmp);
				} else {
					cnt++;
					if (idx == tmp[0]) {
						break;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.substring(0,sb.length()-1));

	}
}