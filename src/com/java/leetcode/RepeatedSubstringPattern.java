package com.java.leetcode;

public class RepeatedSubstringPattern {
	/**
	 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。

	 */
	
	public boolean repeatedSubstringPattern(String s) {
		//思路：那么既然能拆分成多个子串，那么每个子串的长度肯定不能大于原字符串长度的一半，
		//那么我们可以从原字符串长度的一半遍历到1，如果当前长度能被总长度整除，说明可以分成若干个子字符串，
		//我们将这些子字符串拼接起来看跟原字符串是否相等。 如果拆完了都不相等，返回false。
		int n=s.length();
		for(int i=n/2;i>=1;i--) {
			if(n%i==0) {
				int c=n/i;
				String t="";
				for(int j=0;j<c;j++) {
					t+=s.substring(0, i);
				}
				if(t.equals(s)) return true;
			}
		}
		return false;
	}
}
