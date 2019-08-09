package com.java.javaSE经典50题;

import java.util.Scanner;

/**
 * 题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
 * 
 * @author WangShuaiJie
 *
 */
public class Main38 {
	public static void main(String[] args) {
		System.out.println("请输入一串字符：");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();// 获取输入的字符串
		System.out.println("你输入的字符串是：" + input);
		System.out.println("你输入的字符串长度是：" + input.length());
		scanner.close();
	}
}
