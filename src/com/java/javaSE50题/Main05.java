package com.java.javaSE50题;
/**
 * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。(重点)
 * @author WangShuaiJie
 *
 */
public class Main05 {
	public static void main(String[] args) {
		System.out.println(getGcd(319, 377));
	}
	//最大公约数
	private static int getGcd(int m, int n) {
		//辗转相除法，一定确保m>n
		if(m<n) {
			m=m+n;
			n=m-n;
			m=m-n;
		}
		if(m%n == 0) {
			return n;
		}else {
			m=m%n;
			return getGcd(m, n);
		}
	}
	//最小公倍数
	private static int getLcm(int m, int n) {
		return m*n/getGcd(m, n);
	}
}
