package com.demo.offer;

public class Solution32 {
	/**
	 * ��1������n��1���ֵĴ���
	 */
	public int countDigitOne(int n) {
		int count=0;
		for(int i=1;i<=n;i*=10) {
			int a=n/i;//��λ
			int b=n%i;//��λ
			count+=(a+8)/10*i;
			if(a%10==1) {
				count+=b+1;
			}
		}
		return count;
	}
}
