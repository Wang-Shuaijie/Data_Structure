package com.java.javaSE50题;

import java.util.Scanner;

/**
 * 题目：利用条件运算符的嵌套来完成此题： 学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 * 
 * @author WangShuaiJie
 *
 */
public class Main04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		String res = input >= 90 ? "A" : (input >= 60 ? "B" : "C");
		System.out.println(res);
		sc.close();
	}
}
