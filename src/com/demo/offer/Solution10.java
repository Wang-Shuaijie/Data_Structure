package com.demo.offer;

public class Solution10 {
	/**
	 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
	 * 思路：每次将32位的每一个位依次置为1，和n相与，如果结果为1，表示这个位置为1，否则为0
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
	
//位与运算
//	该位运算去除 n 的位级表示中最低的那一位。
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
	
	//封装好的方法
	public int numberOf2(int n) {
		return Integer.bitCount(n);
	}
}
