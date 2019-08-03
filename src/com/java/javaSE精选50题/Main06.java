package com.java.javaSE精选50题;

import java.util.Scanner;

/**
 * 题目：输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数。
 * @author WangShuaiJie
 *
 */
public class Main06 {
//1、获取一行字符串，nextLine（）
//2、把字符串的每一个字符赋值到一个数值中
//3、对比每一个数值在ASK码的范围，就可以确定它符号的类别
//4、char字符ASK码的范围
//     （1）数字0到9： 48~57
//     （2）字母A到Z：65到90 a到z：97到122
//     （3）空格是32
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		int num=0;//数字个数
		int letter=0;//字母个数
		int space=0;//空格个数
		int others=0;//其他个数
		for(char c:input.toCharArray()) {
			if(c>=48 && c<=57) num++;
			else if((c>=65 && c<=90) || (c>=97 && c<=122)) letter++;
			else if(c==32) space++;
			else others++;	
		}
		System.out.println("数字："+num+"个，字母："+letter+"个，空格："+space+"个，其他："+others+"个");         
		sc.close();
	}
}
