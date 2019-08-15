package com.java.campus;

import java.util.Scanner;

/**
 * 
 * @author WangShuaiJie
 *
 */
public class Solution31 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tem = scanner.nextLine();
		int n = Integer.valueOf(tem.split(" ")[0]);
		int m = Integer.valueOf(tem.split(" ")[1]);
		char color[][] = new char[n][m];
		for (int i = 0; i < n; i++) {
			tem = scanner.nextLine();
			for (int j = 0; j < tem.length(); j++) {
				color[i][j] = tem.charAt(j);
			}
		}

		// 获取最小步数
		getMinStep(n, m, color);

		scanner.close();

	}

	/**
	 * 获取最小步数 每画一个线直到颜色不同为止
	 *
	 * @param n
	 * @param m
	 * @param color
	 */
	private static void getMinStep(int n, int m, char color[][]) {

		int step = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (color[i][j] == 'Y') {
					dfs_y(i, j, n, m, color); // 画y
					step++;
				} else if (color[i][j] == 'B') {
					dfs_b(i, j, n, m, color); // 画B
					step++;
				} else if (color[i][j] == 'G') {
					dfs_y(i, j, n, m, color); // 先画y
					step++;
					dfs_b(i, j, n, m, color); // 在画B
					step++;
				}
			}
		}

		System.out.println(step);
	}

	/**
	 * 当前位置画y,是否在后续位置继续画y
	 *
	 * @param x
	 * @param y
	 */
	private static void dfs_y(int x, int y, int n, int m, char color[][]) {
		// 根据要求决定当前位置是否能画y
		if (x >= 0 && x < n && y >= 0 && y < m && (color[x][y] == 'Y' || color[x][y] == 'G')) {
			if (color[x][y] == 'G') {
				color[x][y] = 'B'; // 如果当前位置要求画的是G,那么画了Y之后下一次只能画B
			} else {
				color[x][y] = 'X'; // 如果当前位置要求画的是Y,那么画了Y之后下一次不需要再画
			}

			// 是否连笔继续画，Y对应的是画\，即左上或者右下
			dfs_y(x - 1, y - 1, n, m, color);
			dfs_y(x + 1, y + 1, n, m, color);

		}

	}

	/**
	 * 当前位置画B,是否在后续位置继续画B
	 *
	 * @param x
	 * @param y
	 */
	private static void dfs_b(int x, int y, int n, int m, char color[][]) {
		// 根据要求决定当前位置是否能画B
		if (x >= 0 && x < n && y >= 0 && y < m && (color[x][y] == 'B' || color[x][y] == 'G')) {
			if (color[x][y] == 'G') {
				color[x][y] = 'Y'; // 如果当前位置要求画的是G,那么画了Y之后下一次只能画Y
			} else {
				color[x][y] = 'X'; // 如果当前位置要求画的是B,那么画了B之后下一次不需要再画
			}

			// 是否连笔继续画，B对应的是画/，即左下或者右上
			dfs_b(x + 1, y - 1, n, m, color);
			dfs_b(x - 1, y + 1, n, m, color);

		}
	}
}
