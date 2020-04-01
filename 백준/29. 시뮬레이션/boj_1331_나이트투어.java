package net.acmicpc;

import java.util.Scanner;

public class boj_1331_나이트투어 {

	static int endY, storeY, endX, storeX;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[][] visited = new boolean[6][6];
		boolean flag = false;
		// 나이트가 어떻게 이동?
		// (+1,+2), (-1,+2),(+2,+1), (-1,-2), (+1,-2)
		// (-2,+1), (+2,-1),(-2,-1) 총 8가지
		String start = scanner.next();

		int startX = start.charAt(0) - 'A';

		int startY = Integer.parseInt(start.substring(1, 2)) - 1;

		storeX = startX;
		storeY = startY;
		visited[startX][startY] = true;

		for (int i = 0; i < 35; i++) {
			String end = scanner.next();
			endX = end.charAt(0) - 'A';
			endY = Integer.parseInt(end.substring(1, 2)) - 1;
			if (visited[endX][endY]) {
				flag = true;
				break;
			}
			if ((startX + 1 == endX && startY + 2 == endY) || (startX + 1 == endX && startY - 2 == endY)
					|| (startX - 1 == endX && startY + 2 == endY) || (startX - 1 == endX && startY - 2 == endY)
					|| (startX + 2 == endX && startY + 1 == endY) || (startX + 2 == endX && startY - 1 == endY)
					|| (startX - 2 == endX && startY + 1 == endY) || (startX - 2 == endX && startY - 1 == endY)) {
				startX = endX;
				startY = endY;
				visited[startX][startY] = true;
				continue;
			} else {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Invalid");
		} else {
			if ((storeX + 1 == endX && storeY + 2 == endY) || (storeX + 1 == endX && storeY - 2 == endY)
					|| (storeX - 1 == endX && storeY + 2 == endY) || (storeX - 1 == endX && storeY - 2 == endY)
					|| (storeX + 2 == endX && storeY + 1 == endY) || (storeX + 2 == endX && storeY - 1 == endY)
					|| (storeX - 2 == endX && storeY + 1 == endY) || (storeX - 2 == endX && storeY - 1 == endY)) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid");
			}
		}

	}
}
