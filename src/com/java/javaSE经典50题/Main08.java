package com.java.javaSE经典50题;
/**
 * 题目：一个数如果恰好等于它的因子之和，这个数就称为”完数”。
 * 例如6=1＋2＋3.编程找出1000以内的所有完数。
 * @author WangShuaiJie
 *
 */
public class Main08 {
	public static void main(String[] args) {
		for(int i=1;i<=1000;i++) {
			if(isRightNum(i)) {
				System.out.println(i);
			}
		}
	}
	private static boolean isRightNum(int n) {
		int sum=0;
		//因数不会超过原本数的一半
		for(int i=1;i<=n/2;i++) {
			if(n%i==0) sum=sum+i;
		}
		if(sum==n) return true;
		return false;
	}
}
