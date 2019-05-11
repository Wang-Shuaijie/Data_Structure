package com.demo.offer;

public class Solution10 {
	/**
	 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ
	 * ˼·��ÿ�ν�32λ��ÿһ��λ������Ϊ1����n���룬������Ϊ1����ʾ���λ��Ϊ1������Ϊ0
	 */
	public static int NumberOf(int n) { 
		int sum=0; 
		int index=1; 
		while (index!=0){ 
			if ((n&index)!=0){ 
				sum++; 
			} 
			index=index<<1; 
		} 
		return sum; 
	}
	
//λ������
//	��λ����ȥ�� n ��λ����ʾ����͵���һλ��
//
//	n       : 10110100
//	n-1     : 10110011
//	n&(n-1) : 10110000
	public int numberOf1(int n) {
		int cnt=0;
		while(n != 0) {
			cnt++;
			n=n&(n-1);
		}
		return cnt;
	}
	
	//��װ�õķ���
	public int numberOf2(int n) {
		return Integer.bitCount(n);
	}
}
