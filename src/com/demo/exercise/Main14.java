package com.demo.exercise;

import java.util.Scanner;

/**
 * 输入某年某月某日，判断这一天是这年中的第几天
 * @author WangShuaiJie
 *
 */
public class Main14 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int year=scanner.nextInt();//获取年份
		int month=scanner.nextInt();//获取月份
		int day=scanner.nextInt();//获取天数
		System.out.println(getDays(year, month, day));
	}
	private static int getDays(int year, int month, int day) {
		int res=0;
		int[] arr=new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		res=day;//输入的天数肯定是要加的
		for(int i=0;i<month-1;i++) {
			res+=arr[i];
		}
		if(isLeapYear(year) && month > 2) {
			res=res+1;//闰年多一天
		}
		return res;
	}
	
	//判断是否是闰年
	private static boolean isLeapYear(int n) {
		if((n%4==0 && n%100!=0) || n%400==0) return true;
		return  false;
	}
}
