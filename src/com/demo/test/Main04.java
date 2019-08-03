package com.demo.test;

import java.util.Scanner;

/**
 * 问题描述
　　编写一个程序，输入一个字符串（长度不超过20），然后把这个字符串内的每一个字符进行大小写变换，即将大写字母变成小写，小写字母变成大写，然后把这个新的字符串输出。
　　输入格式：输入一个字符串，而且这个字符串当中只包含英文字母，不包含其他类型的字符，也没有空格。
　　输出格式：输出经过转换后的字符串。
输入输出样例
样例输入
AeDb
样例输出
aEdB
 *
 */
public class Main04 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		for(char c:str.toCharArray()) {
			if(c>=65 && c<=90) {
				System.out.print((char)(c+32));
			}
			if(c>=97 && c<=122) {
				System.out.print((char)(c-32));
			}
		}
		sc.close();
	}
}
