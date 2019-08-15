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

		// ��ȡ��С����
		getMinStep(n, m, color);

		scanner.close();

	}

	/**
	 * ��ȡ��С���� ÿ��һ����ֱ����ɫ��ͬΪֹ
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
					dfs_y(i, j, n, m, color); // ��y
					step++;
				} else if (color[i][j] == 'B') {
					dfs_b(i, j, n, m, color); // ��B
					step++;
				} else if (color[i][j] == 'G') {
					dfs_y(i, j, n, m, color); // �Ȼ�y
					step++;
					dfs_b(i, j, n, m, color); // �ڻ�B
					step++;
				}
			}
		}

		System.out.println(step);
	}

	/**
	 * ��ǰλ�û�y,�Ƿ��ں���λ�ü�����y
	 *
	 * @param x
	 * @param y
	 */
	private static void dfs_y(int x, int y, int n, int m, char color[][]) {
		// ����Ҫ�������ǰλ���Ƿ��ܻ�y
		if (x >= 0 && x < n && y >= 0 && y < m && (color[x][y] == 'Y' || color[x][y] == 'G')) {
			if (color[x][y] == 'G') {
				color[x][y] = 'B'; // �����ǰλ��Ҫ�󻭵���G,��ô����Y֮����һ��ֻ�ܻ�B
			} else {
				color[x][y] = 'X'; // �����ǰλ��Ҫ�󻭵���Y,��ô����Y֮����һ�β���Ҫ�ٻ�
			}

			// �Ƿ����ʼ�������Y��Ӧ���ǻ�\�������ϻ�������
			dfs_y(x - 1, y - 1, n, m, color);
			dfs_y(x + 1, y + 1, n, m, color);

		}

	}

	/**
	 * ��ǰλ�û�B,�Ƿ��ں���λ�ü�����B
	 *
	 * @param x
	 * @param y
	 */
	private static void dfs_b(int x, int y, int n, int m, char color[][]) {
		// ����Ҫ�������ǰλ���Ƿ��ܻ�B
		if (x >= 0 && x < n && y >= 0 && y < m && (color[x][y] == 'B' || color[x][y] == 'G')) {
			if (color[x][y] == 'G') {
				color[x][y] = 'Y'; // �����ǰλ��Ҫ�󻭵���G,��ô����Y֮����һ��ֻ�ܻ�Y
			} else {
				color[x][y] = 'X'; // �����ǰλ��Ҫ�󻭵���B,��ô����B֮����һ�β���Ҫ�ٻ�
			}

			// �Ƿ����ʼ�������B��Ӧ���ǻ�/�������»�������
			dfs_b(x + 1, y - 1, n, m, color);
			dfs_b(x - 1, y + 1, n, m, color);

		}
	}
}
