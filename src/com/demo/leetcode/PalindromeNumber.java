package com.demo.leetcode;

public class PalindromeNumber {
	/**
	 * �ж�һ�������Ƿ��ǻ�������
	 * ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
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
