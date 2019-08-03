package com.java.javaSE精选50题;

import java.util.Scanner;

/**
 * 题目：输入3个数a,b,c，按大小顺序输出。
 * 
 * @author WangShuaiJie
 *
 */
public class Main34 {
	public static void main(String[] args) {
		System.out.println("请输入三个数：");
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();// 获取输入的数
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		scanner.close();
		int temp = 0;
		if (num1 > num2) {// 确保num2>num1
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if (num1 > num3) {// 确保num3>num1
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		if (num2 > num3) {// 确保num3>num2
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		System.out.println("这三个数从大到小排列：" + num3 + "  " + num2 + "   " + num1);
	}
}
