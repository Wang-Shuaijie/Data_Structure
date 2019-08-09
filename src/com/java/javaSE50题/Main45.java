package com.java.javaSE50题;

import java.util.Scanner;

/**
 * 题目：判断一个素数能被几个9整除
 * 
 * @author WangShuaiJie
 *
 */
public class Main45 {
	public static void main(String[] args) {
		// 跟素数有个毛的关系？
		System.out.print("请输入一个数：");
		Scanner scan = new Scanner(System.in);
		long l = scan.nextLong();
		long n = l;
		scan.close();
		int count = 0;
		while (n > 8) {
			n /= 9;
			count++;
		}
		System.out.println(l + "能被" + count + "个9整除。");
	}
}
