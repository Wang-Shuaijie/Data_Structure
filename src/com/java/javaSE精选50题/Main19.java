package com.java.javaSE精选50题;

/**
 * 题目：打印出如下图案（菱形）
 * 
 * @author WangShuaiJie
 *
 */
public class Main19 {
	public static void main(String[] args) {
		// 打印上面部分：
		int n = 4;
		for (int i = 0; i < n; i++) { // 控制行
			for (int k = 3 - i; k > 0; k--) { // 控制*前面空格的输出
				System.out.print(" ");
			}
			// 输出符号，但不要换行
			for (int j = 0; j <= 2 * i; j++) { // 控制列
				System.out.print("*");
			}
			// 输出完符号马上换行
			System.out.println();
		}
		// 打印下面部分
		n = 3;
		for (int i = n; i > 0; i--) { // 控制行
			for (int k = 3 - i + 1; k > 0; k--) { // 控制*前面空格的输出,第一行要加空格
				System.out.print(" ");
			}
			// 输出符号，但不要换行
			for (int j = 0; j <= 2 * i - 2; j++) { // 控制列
				System.out.print("*");
			}
			// 输出完符号马上换行
			System.out.println();
		}
	}
}
