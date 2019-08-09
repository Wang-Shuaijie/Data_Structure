package com.java.javaSE50题;

import java.util.Scanner;

/**
 * 题目：求一个3*3矩阵对角线元素之和 程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出
 * 
 * @author WangShuaiJie
 *
 */
public class Main29 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] arr = new int[3][3];
		// 获取矩阵数字
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		System.out.println("第一条对角线之和：" + (arr[0][0] + arr[1][1] + arr[2][2]));
		System.out.println("第二条对角线之和：" + (arr[0][2] + arr[1][1] + arr[2][0]));
		scanner.close();
	}
}
