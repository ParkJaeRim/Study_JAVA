package net.acmicpc;

import java.util.Scanner;

// 약 45분 소요
public class kakao_2020_문자열압축 {
	static String result;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = Integer.MAX_VALUE;
		if (s.length() == 1) {
			answer = 1;
		} else {
			for (int i = 1; i < s.length(); i++) {
				result = "";
				check(s, 0, i, 1);
				if (answer > result.length()) {
					answer = result.length();
				}
			}
		}
		return answer;
	}

	public static void check(String s, int start, int len, int cnt) {
		if (start + len > s.length() - len) {
			if (cnt > 1) {
				result += cnt;
			}
			result += s.substring(start, start + len);
			result += s.substring(start + len, s.length());
			return;
		}
		if (s.substring(start, start + len).equals(s.substring(start + len, start + (2 * len)))) {
			check(s, start + len, len, cnt + 1);
		} else {
			if (cnt > 1) {
				result += cnt;
			}
			result += s.substring(start, start + len);
			check(s, start + len, len, 1);
		}
	}
}
