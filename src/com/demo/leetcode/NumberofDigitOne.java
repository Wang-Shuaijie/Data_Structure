package com.demo.leetcode;

public class NumberofDigitOne {
	/**
	 * ��1������n��1���ֵĴ���
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13. 

	 */
	public static int countDigitOne(int n) {
		int count=0; 
		for(int i = 1; i <= n; i *= 10){ 
			int a = n / i; // ��λ 
			int b = n % i; // ��λ 
			//(a+8)/10���ж�һ�����Ƿ���ڵ���2
			count += (a+8) / 10 * i; 
			if(a % 10 == 1){ 
				count += b + 1; 
			} 
		} 
		return count;
	}
	
	public long countDigitOne2(long n) { 
		//˼·������λ������Ϊ0����λ�Ͽ��ܳ���1�Ĵ����ɸ���λ����������λ������Ϊ1����λ�Ͽ��ܳ���1�Ĵ��������ܸ���λӰ�컹�ܵ�λӰ�죻����λ�����ִ���1�����λ�ϳ���1��������ɸ���λ����
		long count = 0; // 1�ĸ��� 
		long i = 1; // ��ǰλ 
		long current = 0,after = 0,before = 0; 
		while((n / i) != 0) { 
			before = n / (i * 10); // ��λ
			current = (n / i) % 10; // ��ǰλ
			after = n - (n / i) * i; // ��λ 
			if (current == 0) //���Ϊ0,����1�Ĵ����ɸ�λ����,���ڸ�λ���� * ��ǰλ�� 
				count = count + before * i; 
			else if(current == 1) 
				//���Ϊ1,����1�Ĵ����ɸ�λ�͵�λ����,��λ*��ǰλ+��λ+1 
				count = count + before * i + after + 1; 
			else if (current > 1) 
				// �������1,����1�Ĵ����ɸ�λ����,����λ����+1��* ��ǰλ�� 
				count = count + (before + 1) * i; 
			//ǰ��һλ 
			i = i * 10; 
		} 
		return count; 
	}

	public static void main(String[] args) {
		int n=21;
		System.out.println(countDigitOne(n));
	}

}
