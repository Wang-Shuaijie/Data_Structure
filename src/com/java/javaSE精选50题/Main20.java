package com.java.javaSE精选50题;
/**
 * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13…求出这个数列的前20项之和。
 * @author WangShuaiJie
 *
 */
public class Main20 {
	/**
	 *  1、第一项是2/1
	 *  2、前面一项分子和分母相加的和，为下一项的分子
	 *  3、前面一项分子，为下一项的分母 
	 */
	public static void main(String[] args) {
		float up=2;
		float down=1;
		float temp=0;
		float fraction=up/down;//分数
		float sum=0;
		for(int i=0;i<20;i++) {
			sum+=fraction;
			temp=up+down;
			down=up;
			up=temp;
			fraction=up/down;
		}
		System.out.println(sum);
	}
	
	private static long getGcd(int m, int n) {
		if(m<n) {
			m=m+n;
			n=m-n;
			m=m-n;
		}
		if(m%n==0) return n;
		else {
			m=m%n;
			return getGcd(m, n);
		}
	}
}
