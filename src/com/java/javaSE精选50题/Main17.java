package com.java.javaSE精选50题;
/**
 * 题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 * 以后每天早上都吃了前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
 * @author WangShuaiJie
 *
 */
public class Main17 {
	/*
	 * 天 数 10 9 8 7 6.....1
	 * 桃子数 1 4 10 22 46 
	 * 前一天桃子数*2+2
	 */
	public static void main(String[] args) {
		int res=1;
		for(int i=10;i>=1;i++) {
			res=res*2+2;
		}
		System.out.println(res);
	}
}
