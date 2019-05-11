package com.demo.LeetCode;

public class Numberof1Bits {
	/**
	 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

示例 :

输入: 11
输出: 3
解释: 整数 11 的二进制表示为 00000000000000000000000000001011
	 */
	public int hammingWeight(int n) {
		/**
		 * 用flag来与n的每位做位于运算，来判断1的个数
		 */
		int count=0;
		int flag=1;
		while(flag!=0) {
			if((flag&n)!=0) {
				count++;
			}
			flag=flag<<1;
		}
		return count;
	}
	
	public int hammingWeight2(int n) {
		/**
		 * 如果一个整数不为0，那么这个整数至少有一位是1。
		 * 如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。
		 * 其余所有位将不会受到影响
		 */
		int count=0;
		while(n!=0) {
			count++;
			n=(n-1)&n;
		}
		return count;
	}
}
