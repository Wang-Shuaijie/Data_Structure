package com.demo.offer;

public class Solution32 {
	/**
	 * 从1到整数n中1出现的次数
	 */
	public int countDigitOne(int n) {
		int count=0;
		for(int i=1;i<=n;i*=10) {
			int a=n/i;//高位
			int b=n%i;//低位
			count+=(a+8)/10*i;
			if(a%10==1) {
				count+=b+1;
			}
		}
		return count;
	}
}
