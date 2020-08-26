package net.acmicpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class kakao_실패율 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] stage = new int[8];
		for (int i = 0; i < 8; i++) {
			stage[i] = sc.nextInt();
		}
		solution(1, stage);
	}

	public static int[] solution(int N, int[] stages) {
		ArrayList<nodes> al = new ArrayList<>();
		int[][] result = new int[stages.length][N + 1];
		for (int i = 0; i < result.length; i++) {
			if (stages[i] == 0) {
				break;
			} else {
				for (int j = 1; j < stages[i]; j++) {
					result[i][j] = 1;
				}
			}
		}

		double[] score = new double[stages.length];

		for (int i = 1; i < N + 1; i++) {
			int bunmo = 0;
			int bunja = 0;
			for (int j = 0; j < stages.length; j++) {
				if (i == 1) {
					bunmo++;
					if (result[j][i] == 0) {
						bunja++;
					}
				} else {
					if (result[j][i - 1] == 1) {
						bunmo++;
						if (result[j][i] == 0) {
							bunja++;
						}
					}
				}
			}
			if(bunmo==0) {
				al.add(new nodes(i, 0));
			}else {
			al.add(new nodes(i, (double) bunja / bunmo));
			}
		}

		Collections.sort(al, new Comparator<nodes>() {
			@Override
			public int compare(nodes o1, nodes o2) {
				if (o1.scores > o2.scores) {
					return -1;
				} else if (o1.scores == o2.scores) {
					if (o1.idx > o2.idx) {
						return 1;
					}
					return -1;
				}
				return 1;
			}
		});

		int[] answer = new int[N];
		for (int i = 0; i < al.size(); i++) {
			answer[i]=al.get(i).idx;
//			System.out.println(al.get(i).idx + " " + al.get(i).scores);
		}

		return answer;
	}

	public static class nodes {
		int idx;
		double scores;

		public nodes(int idx, double scores) {
			this.idx = idx;
			this.scores = scores;
		}

	}

}
