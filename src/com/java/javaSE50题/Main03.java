package com.java.javaSE50题;

import java.util.Scanner;

/**
 * 题目：打印出所有的”水仙花数”，所谓”水仙花数”是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个”水仙花数”，因为153=1的三次方＋5的三次方＋3的三次方。
 * @author WangShuaiJie
 *
 */
public class Main03 {
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			if(isRightNum(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean isRightNum(int n) {
		int a=n%10;//个位
		int b=n/10%10;//十位
		int c=n/10/10;//百位
		if(n==a*a*a+b*b*b+c*c*c) return true;
		return false;
	}
}
