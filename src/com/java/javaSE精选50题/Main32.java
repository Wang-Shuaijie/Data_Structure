package com.java.javaSE精选50题;

import java.util.Scanner;

/**
 * 题目：取一个整数a从右端开始的4～7位。
 * @author WangShuaiJie
 *
 */
public class Main32 {
	public static void main(String[] args) {
		System.out.println("输入一个整数：");
	    Scanner scanner=new Scanner(System.in);
	    long num=scanner.nextLong();//获取输入
	    String str=Long.toString(num);//把数字转化为String类型的
	    char[]ch=str.toCharArray();//把String类型的字符，转化为char类型，每一个数字赋值到字符型数组中
	    int n=ch.length;//字符型数组的长度
	    System.out.println("该整数从右端开始的4-7位为："+ch[n-7]+ch[n-6]+ch[n-5]+ch[n-4]);//输出结果
	    scanner.close();//关闭输入流

	}
}
