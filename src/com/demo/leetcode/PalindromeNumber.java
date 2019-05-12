package com.demo.leetcode;

public class PalindromeNumber {
	/**
	 * 判断一个整数是否是回文数。
	 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	 * 121 true
	 */
	public boolean isPalindrome(int x) {
		if(x<0 || x!=0 && x%10 == 0) return false;
		int palind=x;
		int reverse=0;
		while(x>0) {
			
			reverse=reverse*10+x%10;
			x /= 10;
		}
		return palind == reverse;
	}
	
	
	public static boolean isPalindrome2(int x) {
		String str=String.valueOf(x);
		for(int i=0;i<(str.length()/2);i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				return false;
			}
		}
        return true;
    }
	
	
	public static void main(String[] args) {
		int x=12344321;
		System.out.println(isPalindrome2(x));
	}
}
