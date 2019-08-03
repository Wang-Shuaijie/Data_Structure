package com.java.leetcode.˫ָ��;
/**
 * ��Ŀ����������ɾ��һ���ַ����ж��Ƿ��ܹ��ɻ����ַ�����
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * @author WangShuaiJie
 *
 */
public class VaildPalindromeII {
	public boolean validPalindrome(String s) {
		for(int i=0, j=s.length()-1; i<j; i++, j--) {
			if(s.charAt(i)!=s.charAt(j)) {
				return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
			}
		}
		return true;
	}
	
	private boolean isPalindrome(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
