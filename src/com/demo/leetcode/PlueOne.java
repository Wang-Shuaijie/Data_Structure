package com.demo.leetcode;

public class PlueOne {
	/**
	 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

	 */
	public int[] plusOne(int[] digits) {
		int carry=1;
		for(int i=digits.length-1;i>=0;i++) {
			int temp=digits[i]+carry;
			carry=temp/10;
			digits[i]=temp%10;
			if(carry==0) {
				return digits; 
			}
		}
		if(carry!=0) {
			int[] res=new int[digits.length+1];
			res[0]=1;
			return res;
		}
		return digits;
	}
}
