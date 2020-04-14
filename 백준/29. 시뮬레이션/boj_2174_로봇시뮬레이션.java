package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2174_로봇시뮬레이션 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[A + 1][B + 1];

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<String[]> robot = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			String x = st.nextToken();
			String y = st.nextToken();
			String dir = st.nextToken();
			robot.add(new String[] { x, y, dir });

		}
		String a = "";

		aa: for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int whatRobots = Integer.parseInt(st.nextToken());
			String whatDir = st.nextToken();
			int HowMany = Integer.parseInt(st.nextToken());

			int whatRobot = whatRobots - 1;

			while (HowMany > 0) {

				if (robot.get(whatRobot)[2].equals("N")) {
					if (whatDir.equals("L")) {
						robot.get(whatRobot)[2] = "W";

					} else if (whatDir.equals("R")) {
						robot.get(whatRobot)[2] = "E";

					}

					else {
						int tmp = Integer.parseInt(robot.get(whatRobot)[1]) + 1;
						if (tmp > B + 1) {
							System.out.println("Robot " + (whatRobot + 1) + " crashes into the wall");
							a = "wall";
							break aa;
						}
						if (tmp <= B + 1) {
							for (int j = 0; j < robot.size(); j++) {
								if (j != whatRobot && robot.get(j)[0].equals(robot.get(whatRobot)[0])
										&& robot.get(j)[1].equals(robot.get(whatRobot)[1])) {
									System.out.println("Robot " + (whatRobot + 1) + " crashes into robot " + (j + 1));
									a = "robot";
									break aa;
								} else {
									robot.get(whatRobot)[1] = Integer.toString(tmp);
								}
							}
						}
					}
				} else if (robot.get(whatRobot)[2].equals("S")) {
					if (whatDir.equals("L")) {
						robot.get(whatRobot)[2] = "E";

					} else if (whatDir.equals("R")) {
						robot.get(whatRobot)[2] = "W";

					} else {

						int tmp = Integer.parseInt(robot.get(whatRobot)[1]) - 1;
						if (tmp <= 0) {
							System.out.println("Robot " + (whatRobot + 1) + " crashes into the wall");
							a = "wall";
							break aa;
						}

						if (tmp > 0) {
							for (int j = 0; j < robot.size(); j++) {
								if (j != whatRobot && robot.get(j)[0].equals(robot.get(whatRobot)[0])
										&& robot.get(j)[1].equals(robot.get(whatRobot)[1])) {
									System.out.println("Robot " + (whatRobot + 1) + " crashes into robot " + (j + 1));
									a = "robot";
									break aa;

								} else {
									robot.get(whatRobot)[1] = Integer.toString(tmp);
								}
							}
						}
					}
				} else if (robot.get(whatRobot)[2].equals("W")) {
					if (whatDir.equals("L")) {
						robot.get(whatRobot)[2] = "S";

					} else if (whatDir.equals("R")) {
						robot.get(whatRobot)[2] = "N";

					} else {
						int tmp = Integer.parseInt(robot.get(whatRobot)[0]) - 1;
						if (tmp <= 0) {
							System.out.println("Robot " + (whatRobot + 1) + " crashes into the wall");
							a = "wall";
							break aa;
						}
						if (tmp > 0) {
							for (int j = 0; j < robot.size(); j++) {
								if (j != whatRobot && robot.get(j)[0].equals(robot.get(whatRobot)[0])
										&& robot.get(j)[1].equals(robot.get(whatRobot)[1])) {
									System.out.println("Robot " + (whatRobot + 1) + " crashes into robot " + (j + 1));
									a = "robot";
									break aa;

								} else {
									robot.get(whatRobot)[0] = Integer.toString(tmp);
								}
							}
						}
					}
				} else if (robot.get(whatRobot)[2].equals("E")) {
					if (whatDir.equals("L")) {
						robot.get(whatRobot)[2] = "N";

					} else if (whatDir.equals("R")) {
						robot.get(whatRobot)[2] = "S";

					} else {

						int tmp = Integer.parseInt(robot.get(whatRobot)[0]) + 1;
						if (tmp > A + 1) {
							System.out.println("Robot " + (whatRobot + 1) + " crashes into the wall");
							a = "wall";
							break aa;
						}
						if (tmp <= A + 1) {
							for (int j = 0; j < robot.size(); j++) {
								if (j != whatRobot && robot.get(j)[0].equals(robot.get(whatRobot)[0])
										&& robot.get(j)[1].equals(robot.get(whatRobot)[1])) {
									System.out.println("Robot " + (whatRobot + 1) + " crashes into robot " + (j + 1));
									a = "robot";
									break aa;
								} else {
									robot.get(whatRobot)[0] = Integer.toString(tmp);
								}
							}
						}
					}
				}
				HowMany--;
			}
		}
		if (a.equals(""))

		{
			System.out.println("OK");
		}
	}
}
