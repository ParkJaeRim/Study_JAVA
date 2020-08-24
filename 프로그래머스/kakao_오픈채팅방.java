package net.acmicpc;

import java.util.HashMap;
import java.util.Scanner;

public class kakao_오픈채팅방 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] input_data = new String[5];

		for (int i = 0; i < input_data.length; i++) {
			input_data[i] = sc.nextLine();
		}

		solution(input_data);
	}

	public static String[] solution(String[] input_data) {

		String[][] lst = new String[input_data.length][4];
		HashMap<String, String> hm = new HashMap<>();

		int cnt = 0;
		for (int i = 0; i < input_data.length; i++) {
			String x = input_data[i];
			String[] tmp = new String[3];

			tmp = x.split(" ");
			for (int j = 0; j < tmp.length; j++) {
				lst[i][j] = tmp[j];
			}
			if (lst[i][0].equals("Enter")) {
				lst[i][3] = "님이 들어왔습니다.";
				hm.put(lst[i][1], lst[i][2]);
				cnt++;
			} else if (lst[i][0].equals("Leave")) {
				lst[i][3] = "님이 나갔습니다.";
				cnt++;
			} else {
				hm.put(lst[i][1], lst[i][2]);
			}
		}

		String[] answer = new String[cnt];
		int x = 0;
		for (int i = 0; i < lst.length; i++) {
			if (!lst[i][0].equals("Change")) {
				answer[x] = hm.get(lst[i][1]) + lst[i][3];
				x++;
			}
		}

		return answer;
	}

	public static void print(String[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
